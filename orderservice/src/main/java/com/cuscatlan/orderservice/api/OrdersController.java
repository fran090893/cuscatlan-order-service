package com.cuscatlan.orderservice.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuscatlan.orderservice.application.dtos.CreateOrderRequest;
import com.cuscatlan.orderservice.application.services.OrderService;
import com.cuscatlan.orderservice.domain.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/CreateOrder")
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request.getCustomerId(), request.getShippingAddress(), request.getProducts());
    }

    @GetMapping("/GetOrderById")
    public Order getOrderById(@RequestParam Long id) {
        return orderService.getOrderById(id);
    }
    
    
}
