package com.fasttrackit.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket implements Serializable
{
    private String customer;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product)
    {
        this.getProducts().add(product);
    }

    public ProductBasket(String customer)
    {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double totalPrice()
    {
        double total = 0;
        for (Product product : products)
        {
            total += product.getPrice() * product.getQuantity();

        }
        return total;
    }


}
