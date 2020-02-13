package com.ksquareinc.employeesservice.models;

import java.io.Serializable;

public class TimeOff implements Serializable {
    private Long id;
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
