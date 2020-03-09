package com.stadline.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HydraMemberActivity {
	
	@JsonProperty("@id")
    private String id;
	
	@JsonProperty("@type")
    private String type;
	
    private String name;
    private Object clubId;
    private String colorHex;
    private List<String> durations = null;
    private String createdAt;
    private String createdBy;
    private Object templateToken;
    private Boolean isViewable;
    private Boolean isBookable;
    private Object archivedAt;
    private Object archivedBy;

    public HydraMemberActivity() {
    	
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getClubId() {
        return clubId;
    }

    public void setClubId(Object clubId) {
        this.clubId = clubId;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations; 
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

    public Object getTemplateToken() {
        return templateToken;
    }

    public void setTemplateToken(Object templateToken) {
        this.templateToken = templateToken;
    }

    public Boolean getIsViewable() {
        return isViewable;
    }

    public void setIsViewable(Boolean isViewable) {
        this.isViewable = isViewable;
    }

    public Boolean getIsBookable() {
        return isBookable;
    }

    public void setIsBookable(Boolean isBookable) {
        this.isBookable = isBookable;
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



}
