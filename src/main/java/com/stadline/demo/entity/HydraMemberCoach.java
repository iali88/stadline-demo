
package com.stadline.demo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HydraMemberCoach {

	@JsonProperty("@context")
    private String context;
	
	@JsonProperty("@id")
    private String id;
	
	@JsonProperty("@type")
    private String type;
	
    private String givenName;
    private String familyName;
    private Object alternateName;
    private List<String> activities = null;
    private String createdAt;
    private String createdBy;
    private Object archivedAt;
    private Object archivedBy;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Object getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(Object alternateName) {
        this.alternateName = alternateName;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Object getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(Object archivedAt) {
        this.archivedAt = archivedAt;
    }

    public Object getArchivedBy() {
        return archivedBy;
    }

    public void setArchivedBy(Object archivedBy) {
        this.archivedBy = archivedBy;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
