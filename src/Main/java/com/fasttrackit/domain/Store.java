package com.fasttrackit.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "stores")
public class Store implements Serializable {


    @Id
    @GeneratedValue(generator = "store_generator")
    @SequenceGenerator(
            name = "store_generator",
            sequenceName = "store_sequence",
            initialValue = 1000
    )

    private Long id;
    private String name;
    private String adress;
    private String description;
    private List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_Id")

    public long getId()
    {
        return  id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StoreDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", adress='").append(adress).append('\'');
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}