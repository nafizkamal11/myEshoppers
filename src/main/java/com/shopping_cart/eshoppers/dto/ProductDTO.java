package com.shopping_cart.eshoppers.dto;

import java.math.BigDecimal;

/*
 ** 2024, July 15, Monday, 2:31 PM
 */
public class ProductDTO {
    private String productName;
    private String description;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(String productName, String description, BigDecimal price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
