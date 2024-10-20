package com.cuscatlan.orderservice.application.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateOrderRequest {
    @NotNull(message = "products is required")
    private List<OrderProductRequestDTO> products;
    @NotNull(message = "customerId is required")
    private Long customerId;
    @NotNull(message = "shippingAddress is required")
    @NotBlank(message = "shippingAddress is required")
    private String shippingAddress;

    // Constructors
    public CreateOrderRequest(Long customerId, String shippingAddress, List<OrderProductRequestDTO> productRequests) {
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
