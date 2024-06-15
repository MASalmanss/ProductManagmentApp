package com.MaSalman.productmanagement.exeption;

import java.time.LocalDateTime;

public class ErrorDetails {

    private int status;
    private String massage;
    private LocalDateTime timestamp;

    public ErrorDetails(int status, String massage, LocalDateTime timestamp) {
        this.status = status;
        this.massage = massage;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
