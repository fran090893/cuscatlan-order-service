package com.cuscatlan.orderservice.application.dtos;

import java.util.List;

public class CreateOrderRequest {
    private List<OrderProductRequestDTO> products;
    private String customerId;
    private String shippingAddress;

    // Constructors
    public CreateOrderRequest(String customerId, String shippingAddress, List<OrderProductRequestDTO> productRequests) {
        this.customerId = customerId;
        this.shippingAddress = shippingAddress;
        this.products = productRequests;
    }

    // Getters and setters
    public List<OrderProductRequestDTO> getProducts() {
        return products;
    }

    public void setProductIds(List<OrderProductRequestDTO> products) {
        this.products = products;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
