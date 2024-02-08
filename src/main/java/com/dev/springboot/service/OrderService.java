package com.dev.springboot.service;

import com.dev.springboot.dto.OrderRequest;
import com.dev.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
