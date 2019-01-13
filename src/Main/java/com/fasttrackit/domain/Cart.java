package com.fasttrackit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
@Entity
public class Cart
{
    @OneToOne
    private CustomerInformation customerInformation;
@OneToMany
    List<OrderedProduct> productsOrdered;

    public CustomerInformation getCustomerInformation()
    {
        return customerInformation;
    }

    public void setCustomerInformation(CustomerInformation customerInformation)
    {
        this.customerInformation = customerInformation;
    }

    public List<OrderedProduct> getProductsOrdered()
    {
        return productsOrdered;
    }

    public void setProductsOrdered(List<OrderedProduct> productsOrdered)
    {
        this.productsOrdered = productsOrdered;
    }
}
