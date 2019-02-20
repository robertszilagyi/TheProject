package com.fasttrackit.dto;


import com.fasttrackit.domain.CustomerInformation;
import com.fasttrackit.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDTO
{
    private List<Product> products = new ArrayList<>();
    private long id;
    private double totalPrice;
    private CustomerInformation customerInformation;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {

        double totalPrice = 0;
        for (Product product : products)
        {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomerInformation getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(CustomerInformation customerInformation) {
        this.customerInformation = customerInformation;
    }

}
