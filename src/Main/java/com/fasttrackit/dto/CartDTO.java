package com.fasttrackit.dto;


import java.util.ArrayList;
import java.util.List;

public class CartDTO
{

    private long id;
    private CustomerInformationDTO customerInformation;
    private List<ProductDTO> products = new ArrayList<>();

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
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
        for (ProductDTO product : products)
        {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public CustomerInformationDTO getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(CustomerInformationDTO customerInformation) {
        this.customerInformation = customerInformation;
    }

}
