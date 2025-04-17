package com.example.employee_payroll.dto;

public class ResponseDto {

    private String message;
    private Object data;

    public String getMessage() {
        return message;
    }

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
