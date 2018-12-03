package com.fasttrackit.dto;

import com.fasttrackit.domain.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class StoreDTO implements Serializable {


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

    private List<ProductDTO> firstElements= new ArrayList<>();



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

    public List<ProductDTO> getFirstElements()
    {
        return firstElements;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StoreDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", adress='").append(adress).append('\'');
        sb.append(", products=").append(firstElements);
        sb.append('}');
        return sb.toString();
    }
}