package com.cuscatlan.orderservice.infrastructure;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cuscatlan.orderservice.domain.entity.DetailOrder;
import com.cuscatlan.orderservice.domain.entity.Order;
import com.cuscatlan.orderservice.domain.repository.IOrderRepository;

@DataJpaTest
public class OrderRepositoryTest {
    @Autowired
    private IOrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        // arrange
        // Create List<OrderProduct> to add to Order
        List<DetailOrder> orderProducts = Arrays.asList(
            new DetailOrder(1L, 2, 10.0),
            new DetailOrder(2L, 1, 10.0)
        );
        Order order = new Order(1L, "Address 1", orderProducts);
        // act
        Order savedOrder = orderRepository.save(order);
        // assert
        assertNotNull(savedOrder);
    }
}
