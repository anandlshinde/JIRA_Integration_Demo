package com.jiraauto.demo.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiraauto.demo.model.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class JiraTicketService {
	private RestTemplate restTemplate;
	@Value("${jira.user-name}")
	private String username;
	@Value("${jira.secret}")
	private String secret;
	@Value("${jira.base-url}")
	private String baseUrl;
	@Value("${jira.ticket-url}")
	private String ticketCreationUrl;
	@Value("${jira.basic-authToken}")
	private String basicAuthToken;


	@Autowired
	public JiraTicketService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String createJiraTicket(JiraPayload jiraPayload) {
		System.out.println("base url :: "+baseUrl.concat(ticketCreationUrl));
		ResponseEntity<String> response = restTemplate.exchange(baseUrl.concat(ticketCreationUrl), HttpMethod.POST,
				new HttpEntity<JiraPayload>(jiraPayload, getHeaders()), String.class);
		if (response != null) {
			return response.getBody();
		}
		return null;
	}

	public String createJiraTicket_test() {
		JiraPayload jiraPayload=new JiraPayload();
		Project project=new Project();
		project.setKey("HRA");
		Issuetype issuetype=new Issuetype();
		issuetype.setid("1");

		Fields fields=new Fields();
		fields.setProject(project);
		fields.setIssuetype(issuetype);
		fields.setSummary("Delete: Detail of WO ");
		fields.setDescription("Delete: Detail regarding WO");
		Customfield_10302 customfield_10302=new Customfield_10302();
		customfield_10302.setId("10312");
		fields.setCustomfield_10302(customfield_10302);
		Customfield_10501 customfield_10501=new Customfield_10501();
		customfield_10501.setId("13901");
		fields.setCustomfield_10501(customfield_10501);
		Components components=new Components();
		components.setId("35918");
		List<Components> componentsList=new ArrayList<>();
		componentsList.add(components);
		fields.setComponents(componentsList);
		Customfield_13208 customfield_13208=new Customfield_13208();
		customfield_13208.setId("28109");
		List<Customfield_13208> customfield_13208List=new ArrayList<>();
		customfield_13208List.add(customfield_13208);
		fields.setCustomfield_13208(customfield_13208List);
		Customfield_10207 customfield_10207=new Customfield_10207();

		customfield_10207.setId("14630");
		List<Customfield_10207> customfield_10207List=new ArrayList<>();
		customfield_10207List.add(customfield_10207);
		fields.setCustomfield_10207(customfield_10207List);


		Customfield_10516 customfield_10516=new Customfield_10516();
		customfield_10516.setId("15978");
		fields.setCustomfield_10516(customfield_10516);
		Customfield_10507 customfield_10507=new Customfield_10507();
		customfield_10507.setId("15997");
		fields.setCustomfield_10507(customfield_10507);
		jiraPayload.setFields(fields);


		ObjectMapper objectMapper=new ObjectMapper();
		try {
			String value = objectMapper.writeValueAsString(jiraPayload);
			System.out.println("value :: "+value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		System.out.println("base url :: "+baseUrl.concat(ticketCreationUrl));
//		ResponseEntity<String> response = restTemplate.exchange(baseUrl.concat(ticketCreationUrl), HttpMethod.POST,
//				new HttpEntity<JiraPayload>(jiraPayload, getHeaders()), String.class);

		StatusResponse statusResponse = buildWebClient().post()
				.uri(uriBuilder -> uriBuilder
						.path(ticketCreationUrl)
						.build())
				.header("Authorization", getHeadersData())
				.header("Content-Type", "application/json")
				.body(Mono.just(jiraPayload), JiraPayload.class)
				.retrieve()
				.bodyToMono(StatusResponse.class)
				.block();

		if (statusResponse != null) {
//			return response.getBody();
			return statusResponse.getKey();
		}
		return null;
	}

	public String getIssueStatusJiraTicket() {
		System.out.println(baseUrl.concat(ticketCreationUrl));
		ticketCreationUrl=ticketCreationUrl.concat("/5132667?fields=status");

		HttpEntity<?> httpEntity = new HttpEntity<>(getHeaders());


		ResponseEntity<String> response = restTemplate.exchange(baseUrl.concat(ticketCreationUrl),
				HttpMethod.GET,httpEntity, String.class);

		ResponseEntity<StatusResponse> status_response = restTemplate.exchange(baseUrl.concat(ticketCreationUrl),
				HttpMethod.GET,httpEntity, StatusResponse.class);

		System.out.println("Issue Description :: "+status_response.getBody().getFields().getStatus().getDescription());
		System.out.println("Issue Status :: "+status_response.getBody().getFields().getStatus().getName());

		if (response != null) {
			return response.getBody();
		}
		return null;
	}


	public String getIssueFieldsJiraTicket() {

		HttpEntity<?> httpEntity = new HttpEntity<>(getHeaders());


		ResponseEntity<String> response = restTemplate.exchange("https://jiraprf.intuit.com/rest/api/2/field",
				HttpMethod.GET,httpEntity, String.class);


		if (response != null) {
			return response.getBody();
		}
		return null;
	}

	public void getIssueDetails(String issueKey){

		System.out.println("ticketCreationUrl "+ticketCreationUrl);
		String issueId="5132667";
		StatusResponse statusResponse = buildWebClient().get()
				.uri(uriBuilder -> uriBuilder
                       .path(ticketCreationUrl.concat("/"+issueKey))
                       .queryParam("fields", "status")
                       .build())
				.header("Authorization", this.basicAuthToken)
				.header("Content-Type", "application/json")
				.retrieve()
				.bodyToMono(StatusResponse.class)
				.block();


		System.out.println("webclient call response status:: "+statusResponse.getFields().getStatus().getName());

	}

	public String getHeadersData() {
		String auth = username + ":" + secret;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());

		return  "Basic " + new String(encodedAuth);
	}



	public HttpHeaders getHeaders() {
		String auth = username + ":" + secret;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Authorization", authHeader);
//		headers.set("Content-Type","application/json");


//		String plainCreds =  username + ":" + secret;
//		byte[] plainCredsBytes = plainCreds.getBytes(Charset.forName("US-ASCII"));
//		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
//		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization",authHeader);
		headers.set("Content-Type","application/json");
		return headers;
	}

	private WebClient buildWebClient(){
		return WebClient.builder()
				.baseUrl(baseUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
}
