package com.fasttrackit.domain;


import java.io.Serializable;

public class Product implements Serializable
{
    private String productName;
    private double price;
    private ProductCategory productCategory;
    private int quantity;

    public Product(String productName, double price, ProductCategory productCategory, int quantity) {
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
        this.quantity = quantity;

    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
