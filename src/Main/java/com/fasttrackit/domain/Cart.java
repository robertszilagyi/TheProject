package com.fasttrackit.domain;


import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(generator = "store_generator")
    @SequenceGenerator(
            name = "store_generator",
            sequenceName = "store_sequence",
            initialValue = 1
    )
    private long id;

    @OneToOne(targetEntity = CustomerInformation.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customerInformation_Id")
    private CustomerInformation customerInformation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_Id")
    private List<Product> products = new ArrayList<>();

    private int totalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomerInformation getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(CustomerInformation customerInformation) {
        this.customerInformation = customerInformation;
    }

    public double computeTotalPrice()
    {
        double total = 0;
        for (Product product : products)
        {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("products=").append(products);
        sb.append(", id=").append(id);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", customerInformation=").append(customerInformation);
        sb.append('}');
        return sb.toString();
    }
}