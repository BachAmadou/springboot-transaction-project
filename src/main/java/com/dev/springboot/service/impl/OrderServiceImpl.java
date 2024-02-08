package com.dev.springboot.service.impl;

import com.dev.springboot.dto.OrderRequest;
import com.dev.springboot.dto.OrderResponse;
import com.dev.springboot.entity.Order;
import com.dev.springboot.entity.Payment;
import com.dev.springboot.repository.OrderRepository;
import com.dev.springboot.repository.PaymentRepository;
import com.dev.springboot.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        


        return null;
    }
}































