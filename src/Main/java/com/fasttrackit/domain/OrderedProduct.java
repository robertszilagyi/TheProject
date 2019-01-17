package com.fasttrackit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity


public class OrderedProduct
{
@Id


    private Product product;
    private int quantity;




    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
