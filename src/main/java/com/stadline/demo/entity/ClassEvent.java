
package com.stadline.demo.entity;

public class ClassEvent {

    private String club;
    private String studio;
    private String activity;
    private String coach;
    private Integer attendingLimit;
    private Integer queueLimit;
    private String privateComment;
    private String startedAt;
    private String endedAt;

    public ClassEvent() {
    	
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

    public Integer getAttendingLimit() {
        return attendingLimit;
    }

    public void setAttendingLimit(Integer attendingLimit) {
        this.attendingLimit = attendingLimit;
    }

    public Integer getQueueLimit() {
        return queueLimit;
    }

    public void setQueueLimit(Integer queueLimit) {
        this.queueLimit = queueLimit;
    }

    public String getPrivateComment() {
        return privateComment;
    }

    public void setPrivateComment(String privateComment) {
        this.privateComment = privateComment;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
    }

}
