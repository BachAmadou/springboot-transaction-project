package com.dev.springboot.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderTrackingNumber;
    private String status;
    private String message;
}
