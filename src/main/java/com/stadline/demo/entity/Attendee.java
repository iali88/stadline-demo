
package com.stadline.demo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attendee {

    private String contactId;
    private String contactGivenName;
    private String contactFamilyName;
    private String contactNumber;
    private String contactClubId;
    private String contactDetails;
    private String contactCreatedAt;
    private String contactTagUsed;
    private String contactCounterUsed;
    private String contactPictureId;
    private String contactChannelUsed;
    private ClassEvent classEvent;
    private String cancelReason;
    private List<String> warnings = null;
    private String createdAt;
    private String createdBy;
    private String canceledAt;
    private String canceledBy;
    private String validatedAt;
    private String validatedBy;
    private String queuedAt;
    private String queuedBy;
    private String deletedAt;
    private String deletedBy;
    private String state;
    private Integer costSignIn;
    private Integer creditSignOut;
    private String bookedItem;
    private Boolean showed;
    private String activityName;
    private String classEventStartedAt;
    private String classLayout;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    public Attendee() {
    	
    }
    
    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactGivenName() {
        return contactGivenName;
    }

    public void setContactGivenName(String contactGivenName) {
        this.contactGivenName = contactGivenName;
    }

    public String getContactFamilyName() {
        return contactFamilyName;
    }

    public void setContactFamilyName(String contactFamilyName) {
        this.contactFamilyName = contactFamilyName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactClubId() {
        return contactClubId;
    }

    public void setContactClubId(String contactClubId) {
        this.contactClubId = contactClubId;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getContactCreatedAt() {
        return contactCreatedAt;
    }

    public void setContactCreatedAt(String contactCreatedAt) {
        this.contactCreatedAt = contactCreatedAt;
    }

    public String getContactTagUsed() {
        return contactTagUsed;
    }

    public void setContactTagUsed(String contactTagUsed) {
        this.contactTagUsed = contactTagUsed;
    }

    public String getContactCounterUsed() {
        return contactCounterUsed;
    }

    public void setContactCounterUsed(String contactCounterUsed) {
        this.contactCounterUsed = contactCounterUsed;
    }

    public String getContactPictureId() {
        return contactPictureId;
    }

    public void setContactPictureId(String contactPictureId) {
        this.contactPictureId = contactPictureId;
    }

    public String getContactChannelUsed() {
        return contactChannelUsed;
    }

    public void setContactChannelUsed(String contactChannelUsed) {
        this.contactChannelUsed = contactChannelUsed;
    }

    public ClassEvent getClassEvent() {
        return classEvent;
    }

    public void setClassEvent(ClassEvent classEvent) {
        this.classEvent = classEvent;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
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

    public String getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getCanceledBy() {
        return canceledBy;
    }

    public void setCanceledBy(String canceledBy) {
        this.canceledBy = canceledBy;
    }

    public String getValidatedAt() {
        return validatedAt;
    }

    public void setValidatedAt(String validatedAt) {
        this.validatedAt = validatedAt;
    }

    public String getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(String validatedBy) {
        this.validatedBy = validatedBy;
    }

    public String getQueuedAt() {
        return queuedAt;
    }

    public void setQueuedAt(String queuedAt) {
        this.queuedAt = queuedAt;
    }

    public String getQueuedBy() {
        return queuedBy;
    }

    public void setQueuedBy(String queuedBy) {
        this.queuedBy = queuedBy;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCostSignIn() {
        return costSignIn;
    }

    public void setCostSignIn(Integer costSignIn) {
        this.costSignIn = costSignIn;
    }

    public Integer getCreditSignOut() {
        return creditSignOut;
    }

    public void setCreditSignOut(Integer creditSignOut) {
        this.creditSignOut = creditSignOut;
    }

    public String getBookedItem() {
        return bookedItem;
    }

    public void setBookedItem(String bookedItem) {
        this.bookedItem = bookedItem;
    }

    public Boolean getShowed() {
        return showed;
    }

    public void setShowed(Boolean showed) {
        this.showed = showed;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getClassEventStartedAt() {
        return classEventStartedAt;
    }

    public void setClassEventStartedAt(String classEventStartedAt) {
        this.classEventStartedAt = classEventStartedAt;
    }

    public String getClassLayout() {
        return classLayout;
    }

    public void setClassLayout(String classLayout) {
        this.classLayout = classLayout;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
