package com.dev.springboot.dto;

import com.dev.springboot.entity.Order;
import com.dev.springboot.entity.Payment;
import lombok.Data;

@Data
public class OrderRequest {
    private Order order;
    private Payment payment;
}
