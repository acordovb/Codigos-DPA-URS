package com.urs.bcknd_dashboard.model;

public class StatusResponse {
    private String status;
    private String content;

    public StatusResponse(String status, String content) {
        this.status = status;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}