package com.jiraauto.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jiraauto.demo.model.JiraPayload;
import com.jiraauto.demo.service.JiraTicketService;

@RestController
public class ServiceTicketController {

	private JiraTicketService jiraTicketService;

	@Autowired
	public ServiceTicketController(JiraTicketService jiraTicketService) {
		this.jiraTicketService = jiraTicketService;
	}

	@PostMapping("/ticketcreate")
	public ResponseEntity<String> createJiraTicket(@RequestBody JiraPayload jiraPayload) {
		try {
			System.out.println("jiraPayload :: "+jiraPayload);
			String response = jiraTicketService.createJiraTicket(jiraPayload);
			return new ResponseEntity<String>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to process your request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/ticketjiracreate")
	public ResponseEntity<String> createJiraTicket() {
		try {
			String response = jiraTicketService.createJiraTicket_test();
			return new ResponseEntity<String>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to process your request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getIssueStatus")
	public ResponseEntity<String> getIssueStatusJiraTicket() {
		try {
			String response = jiraTicketService.getIssueStatusJiraTicket();
			System.out.println("response :: "+response);
			//jiraTicketService.getIssueDetails();
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to process your request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getJIraIssueStatus/{issueKey}")
	public ResponseEntity<String> getIssueStatusTicket(@PathVariable String issueKey) {
		try {
			jiraTicketService.getIssueDetails(issueKey);
			return new ResponseEntity<String>("response", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to process your request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getIssueFields")
	public ResponseEntity<String> getIssueFieldsJiraTicket() {
		try {
			String response = jiraTicketService.getIssueFieldsJiraTicket();
			System.out.println("Fields response :: "+response);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to process your request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
