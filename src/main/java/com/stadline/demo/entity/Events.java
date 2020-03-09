
package com.stadline.demo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events {

    private String id;
    private Object startedAt;
    private Object endedAt;
    private String summary;
    private String description;
    private String privateComment;
    private String club;
    private String studio;
    private String activity;
    private String coach;
    private String recurrence;
    private Integer attendingLimit;
    private List<BookedAttendee> bookedAttendees = null;
    private Integer queueLimit;
    private List<QueuedAttendee> queuedAttendees = null;
    private Object createdAt;
    private String createdBy;
    private Object updatedAt;
    private String updatedBy;
    private Object deletedAt;
    private String deletedBy;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Events() {
    	
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Object startedAt) {
        this.startedAt = startedAt;
    }

    public Object getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Object endedAt) {
        this.endedAt = endedAt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivateComment() {
        return privateComment;
    }

    public void setPrivateComment(String privateComment) {
        this.privateComment = privateComment;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public Integer getAttendingLimit() {
        return attendingLimit;
    }

    public void setAttendingLimit(Integer attendingLimit) {
        this.attendingLimit = attendingLimit;
    }

    public List<BookedAttendee> getBookedAttendees() {
        return bookedAttendees;
    }

    public void setBookedAttendees(List<BookedAttendee> bookedAttendees) {
        this.bookedAttendees = bookedAttendees;
    }

    public Integer getQueueLimit() {
        return queueLimit;
    }

    public void setQueueLimit(Integer queueLimit) {
        this.queueLimit = queueLimit;
    }

    public List<QueuedAttendee> getQueuedAttendees() {
        return queuedAttendees;
    }

    public void setQueuedAttendees(List<QueuedAttendee> queuedAttendees) {
        this.queuedAttendees = queuedAttendees;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
