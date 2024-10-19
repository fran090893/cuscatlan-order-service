package com.cuscatlan.orderservice.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String shippingAddress;
    private Double total;
    private String status;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailOrder> products;

    public Order() {}

    public Order(Long pCustomerId, String pShippingAddress, List<DetailOrder> pProducts) {
        this.createdAt = LocalDateTime.now();
        customerId = pCustomerId;
        products = pProducts;
        shippingAddress = pShippingAddress;
        status = "pending";
        // Calculate total
        total = products.stream()
            .mapToDouble(op -> op.getPrice() * op.getQuantity())
            .sum();
    }

    // Getters and setters 
    public Long getId(){
        return id;
    }

    public Long getCustomerId(){
        return customerId;
    }

    public Double getTotal(){
        return total;
    }

    public List<DetailOrder> getProducts(){
        return products;
    }

    public String getStatus(){
        return status;
    }

    public String getShippingAddress(){
        return shippingAddress;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

}
