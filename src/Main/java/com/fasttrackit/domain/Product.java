package com.fasttrackit.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
@Entity

public class Product implements Serializable {
@Id
    @GeneratedValue(generator = "store_generator")
    @SequenceGenerator(
            name = "store_generator",
            sequenceName = "store_sequence",
            initialValue = 1
    )
    private long id;

    private String productName;
    private String price;
    private String manufacturer;
    private String stock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getStock()
    {
        return stock;
    }

    public void setStock(String stock)
    {
        this.stock = stock;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDTO{");
        sb.append("id=").append(id);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", price=").append(price);
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}


