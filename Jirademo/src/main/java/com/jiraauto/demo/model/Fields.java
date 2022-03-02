
package com.jiraauto.demo.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "project",
    "summary",
    "description",
    "issuetype",
    "customfield_10302",
    "customfield_10501",
    "components",
    "customfield_13208",
    "customfield_10207",
    "customfield_10516",
    "customfield_10507"
})
@Generated("jsonschema2pojo")
public class Fields {

    @JsonProperty("project")
    private Project project;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("description")
    private String description;
    @JsonProperty("issuetype")
    private Issuetype issuetype;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("customfield_10302")
    private Customfield_10302 customfield_10302;
    @JsonProperty("customfield_10501")
    private Customfield_10501 customfield_10501;
    @JsonProperty("components")
    private List<Components> components;
    @JsonProperty("customfield_13208")
    private List<Customfield_13208> customfield_13208;
    @JsonProperty("customfield_10207")
    private List<Customfield_10207> customfield_10207;
    @JsonProperty("customfield_10516")
    private Customfield_10516 customfield_10516;
    @JsonProperty("customfield_10507")
    private Customfield_10507  customfield_10507;

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("issuetype")
    public Issuetype getIssuetype() {
        return issuetype;
    }

    @JsonProperty("issuetype")
    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    public Customfield_10302 getCustomfield_10302() {
        return customfield_10302;
    }

    public void setCustomfield_10302(Customfield_10302 customfield_10302) {
        this.customfield_10302 = customfield_10302;
    }

    public Customfield_10501 getCustomfield_10501() {
        return customfield_10501;
    }

    public void setCustomfield_10501(Customfield_10501 customfield_10501) {
        this.customfield_10501 = customfield_10501;
    }

    public List<Components> getComponents() {
        return components;
    }

    public void setComponents(List<Components> components) {
        this.components = components;
    }

    public List<Customfield_13208> getCustomfield_13208() {
        return customfield_13208;
    }

    public void setCustomfield_13208(List<Customfield_13208> customfield_13208) {
        this.customfield_13208 = customfield_13208;
    }

    public List<Customfield_10207> getCustomfield_10207() {
        return customfield_10207;
    }

    public void setCustomfield_10207(List<Customfield_10207> customfield_10207) {
        this.customfield_10207 = customfield_10207;
    }

    public Customfield_10516 getCustomfield_10516() {
        return customfield_10516;
    }

    public void setCustomfield_10516(Customfield_10516 customfield_10516) {
        this.customfield_10516 = customfield_10516;
    }

    public Customfield_10507 getCustomfield_10507() {
        return customfield_10507;
    }

    public void setCustomfield_10507(Customfield_10507 customfield_10507) {
        this.customfield_10507 = customfield_10507;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Fields.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("project");
        sb.append('=');
        sb.append(((this.project == null)?"<null>":this.project));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("issuetype");
        sb.append('=');
        sb.append(((this.issuetype == null)?"<null>":this.issuetype));
        sb.append(',');
        sb.append("customfield_10302");
        sb.append('=');
        sb.append(((this.customfield_10302 == null)?"<null>":this.customfield_10302));
        sb.append(',');
        sb.append("customfield_10501");
        sb.append('=');
        sb.append(((this.customfield_10501 == null)?"<null>":this.customfield_10501));
        sb.append(',');
        sb.append("components");
        sb.append('=');
        sb.append(((this.components == null)?"<null>":this.components));
        sb.append(',');
        sb.append("customfield_13208");
        sb.append('=');
        sb.append(((this.customfield_13208 == null)?"<null>":this.customfield_13208));
        sb.append(',');
        sb.append("customfield_10207");
        sb.append('=');
        sb.append(((this.customfield_10207 == null)?"<null>":this.customfield_10207));
        sb.append(',');
        sb.append("customfield_10516");
        sb.append('=');
        sb.append(((this.customfield_10516 == null)?"<null>":this.customfield_10516));
        sb.append(',');
        sb.append("customfield_10507");
        sb.append('=');
        sb.append(((this.customfield_10507 == null)?"<null>":this.customfield_10507));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
