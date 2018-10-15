package com.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class ComponentePC
{
    private String nume;
    private int pret;

    private List<ComponentePC> componentePc = new ArrayList<>();
    private String NumeProdus;



    public String getNume()
    {
        return nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public int getPret()
    {
        return pret;
    }

    public void setPret(int pret)
    {
        this.pret = pret;
    }
}
