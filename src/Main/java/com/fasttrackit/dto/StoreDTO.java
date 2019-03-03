package com.fasttrackit.dto;


import com.fasttrackit.domain.Store;

import java.util.ArrayList;
import java.util.List;



public class StoreDTO extends Store
{



    private long id;

    private String name;
    private String adress;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFirstElements(List<ProductDTO> firstElements) {
        this.firstElements = firstElements;
    }

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



    }
