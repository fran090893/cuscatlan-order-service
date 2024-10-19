package com.cuscatlan.orderservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuscatlan.orderservice.domain.entity.Order;

public interface IOrderRepository extends  JpaRepository<Order, Long>{
    
}
