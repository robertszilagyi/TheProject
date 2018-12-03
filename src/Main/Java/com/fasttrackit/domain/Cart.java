package com.fasttrackit.domain;

import java.util.List;

public class Cart
{
    private CustomerInformation customerInformation;

    List<OrderedProduct> productsOrdered;

    public CustomerInformation getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(CustomerInformation customerInformation) {
        this.customerInformation = customerInformation;
    }

    public List<OrderedProduct> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(List<OrderedProduct> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }
}
