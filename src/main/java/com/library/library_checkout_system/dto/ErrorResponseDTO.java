package com.library.library_checkout_system.dto;

public class ErrorResponseDTO {
    private Integer status;
    private String message;
    private long timestamp;

    public ErrorResponseDTO(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
