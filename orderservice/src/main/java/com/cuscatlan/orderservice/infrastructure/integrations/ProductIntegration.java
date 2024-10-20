package com.cuscatlan.orderservice.infrastructure.integrations;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.orderservice.crosscutting.exception.ExternalServiceException;
import com.cuscatlan.orderservice.domain.dtos.ProductDTO;

@Repository
public class ProductIntegration {

    private final RestTemplate restTemplate;

    private String productServiceUrl = "http://localhost:8080/products/";

    public ProductIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    
    public List<ProductDTO> getProductsByIds(String idsString) {
       
        try {
            String url = productServiceUrl + "getProductsById?ids=" + idsString;

            ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
            return List.of(products);
        } catch (Exception e) {
            throw new ExternalServiceException("Failed to call getProductsByIds." + e.getMessage());
        }
    
        
       
    }
}
