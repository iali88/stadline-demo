
package com.stadline.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HydraMemberStudio {

	@JsonProperty("@context")
    private String context;
	
	@JsonProperty("@id")
    private String id;
	
	@JsonProperty("@type")
    private String type;
    
	private String name;
    private String club;
    private Object zoneId;
    private Object capacity;
    private Object overbooking;
    private Object streetAddress;
    private Object postalCode;
    private Object addressLocality;
    private Object addressCountry;
    private String createdAt;
    private String createdBy;
    private String tags;
    private Object archivedAt;
    private Object archivedBy;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Object getZoneId() {
        return zoneId;
    }

    public void setZoneId(Object zoneId) {
        this.zoneId = zoneId;
    }

    public Object getCapacity() {
        return capacity;
    }

    public void setCapacity(Object capacity) {
        this.capacity = capacity;
    }

    public Object getOverbooking() {
        return overbooking;
    }

    public void setOverbooking(Object overbooking) {
        this.overbooking = overbooking;
    }

    public Object getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(Object streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Object getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(Object addressLocality) {
        this.addressLocality = addressLocality;
    }

    public Object getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(Object addressCountry) {
        this.addressCountry = addressCountry;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
