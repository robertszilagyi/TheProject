package com.fasttrackit;


import java.util.ArrayList;
import java.util.List;

public class ProductCategory
{
private String name;


private List<Product> products = new ArrayList<>();

public ProductCategory (String name)
{
    this.name = name;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}