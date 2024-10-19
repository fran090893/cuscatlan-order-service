package com.cuscatlan.orderservice.domain.dtos;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String image;

    public ProductDTO(Long id, String name, String description, double price,String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public void setId(Long pId) {
        id = pId;
    }
    public void setName(String name) {
        this.name= name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
