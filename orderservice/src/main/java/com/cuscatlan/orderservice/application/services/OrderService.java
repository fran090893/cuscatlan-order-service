package com.cuscatlan.orderservice.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cuscatlan.orderservice.application.dtos.OrderProductRequestDTO;
import com.cuscatlan.orderservice.domain.dtos.ProductDTO;
import com.cuscatlan.orderservice.domain.entity.Order;
import com.cuscatlan.orderservice.domain.entity.OrderProduct;
import com.cuscatlan.orderservice.domain.repository.IOrderRepository;
import com.cuscatlan.orderservice.infrastructure.integrations.ProductIntegration;


@Service
public class OrderService {

    private final IOrderRepository orderRepository;
    private final ProductIntegration productIntegration;

    public OrderService(IOrderRepository orderRepository, ProductIntegration productIntegration) {
        this.orderRepository = orderRepository;
        this.productIntegration = productIntegration;
    }

    public Order createOrder(String customerId, String shippingAddress, List<OrderProductRequestDTO> productRequests) {
        // get the product ids from the request
        List<Long> productIds = productRequests.stream()
            .map(OrderProductRequestDTO::getProductId)
            .collect(Collectors.toList());
        
        String idsString = productIds.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(","));
            
        // get the products from the product microservice
        List<ProductDTO> products = productIntegration.getProductsByIds(idsString);

        // Create new List<OrderProduct> to add to Order
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (ProductDTO productDTO : products) {
            // Obtener la cantidad del producto a partir de los requestDTOs
            OrderProductRequestDTO requestDTO = productRequests.stream()
                .filter(req -> req.getProductId().equals(productDTO.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found in request"));

            int quantity = requestDTO.getQuantity();

            // Crear una instancia de OrderProduct para la orden
            OrderProduct orderProduct = new OrderProduct(productDTO.getId(), quantity, productDTO.getPrice());
            //add orderProduct to List<OrderProduct>
            orderProducts.add(orderProduct);
        }

        // Create order
        Order order = new Order(customerId, shippingAddress, orderProducts);
        
        // save order
        order = orderRepository.save(order);

        return order;
    }
}
