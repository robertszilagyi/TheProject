package com.fasttrackit.domain;

//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductBasket implements Serializable
//{
//    private String customer;
//    private List<ProductDTO> products = new ArrayList<>();
//
//    public void addProduct(ProductDTO product)
//    {
//        this.getProductDTOS().add(product);
//    }
//
//    public ProductBasket(String customer)
//    {
//        this.customer = customer;
//    }
//
//    public String getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(String customer) {
//        this.customer = customer;
//    }
//
//    public List<ProductDTO> getProductDTOS() {
//        return products;
//    }
//
//    public void setProductDTOS(List<ProductDTO> products) {
//        this.products = products;
//    }
//
//    public double totalPrice()
//    {
//        double total = 0;
//        for (ProductDTO product : products)
//        {
//            total += product.getPrice() * product.getQuantity();
//
//        }
//        return total;
//    }
//
//
//}
