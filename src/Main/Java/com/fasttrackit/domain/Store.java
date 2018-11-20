package com.fasttrackit.domain;

import java.util.HashSet;
import java.util.Set;

public class Store
{
    private String name;
    private Set<ProductCategory> productCategory = new HashSet<>();

    public Store(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductCategory> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Set<ProductCategory> productCategory) {
        this.productCategory = productCategory;
    }
}
