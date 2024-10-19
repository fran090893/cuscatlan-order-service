package com.cuscatlan.orderservice.infrastructure.integrations;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

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
            System.out.println("URL: " + url);  // Para depuración

            ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
            return List.of(products);
        } catch (Exception e) {
            e.printStackTrace();  // Mostrar cualquier error que ocurra
            return List.of();  // Return an empty list in case of an error
        }
    
        
       
    }
}
