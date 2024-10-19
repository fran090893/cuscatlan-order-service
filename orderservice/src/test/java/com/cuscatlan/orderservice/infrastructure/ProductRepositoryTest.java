package com.cuscatlan.orderservice.infrastructure;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.orderservice.domain.dtos.ProductDTO;
import com.cuscatlan.orderservice.infrastructure.integrations.ProductIntegration;

public class ProductRepositoryTest {
     @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductIntegration productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnListOfProducts() {
        // Arrange
        ProductDTO[] mockResponse = new ProductDTO[] {
            new ProductDTO(1L, "Product 1",  "Description 1", 100.0, "Category 1", "image1.jpg"),
            new ProductDTO(2L, "Product 2",  "Description 2", 200.0, "Category 2", "image2.jpg")
        };

        // Mock the RestTemplate call
        when(restTemplate.getForObject("http://localhost:8080/products/getProductsById?ids=1,2", ProductDTO[].class))
            .thenReturn(mockResponse);

        // Act
        List<ProductDTO> products = productRepository.getProductsByIds("1,2");

        // Assert
        assertNotNull(products);
        assertEquals(2, products.size());

        ProductDTO firstProduct = products.get(0);
        assertEquals(1L, firstProduct.getId());
        assertEquals(100.0, firstProduct.getPrice());
    }
}
