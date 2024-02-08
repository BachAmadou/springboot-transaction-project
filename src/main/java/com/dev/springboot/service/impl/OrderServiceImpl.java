package com.dev.springboot.service.impl;

import com.dev.springboot.dto.OrderRequest;
import com.dev.springboot.dto.OrderResponse;
import com.dev.springboot.entity.Order;
import com.dev.springboot.entity.Payment;
import com.dev.springboot.exception.PaymentException;
import com.dev.springboot.repository.OrderRepository;
import com.dev.springboot.repository.PaymentRepository;
import com.dev.springboot.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional // To avoid or manage data inconsistency
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        // This method has 2 functions:

        // 1 - Save the order details
        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);


        // 2 - Save the payment details
        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment type is not supported");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        // Once payment is done correctly
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}































