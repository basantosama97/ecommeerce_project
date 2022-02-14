package com.rest.ecommerce.project.category.cart;

public class ApiResponse {
    private Boolean success;
    private String message;
    private JwtUser username;

    public JwtUser getUsername() {
        return username;
    }

    public void setUsername(JwtUser username) {
        this.username = username;
    }

    public ApiResponse(Boolean success, String message, JwtUser username) {
        this.success = success;
        this.message = message;
        this.username = username;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
