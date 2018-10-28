package com.fasttrackit;

public class Orders extends PCComponents
{
private String customerName;
private String adress;
private String itemsBought;
private double totalPrice;


    public Orders(String customerName, String adress, String itemsBought)
    {
        this.customerName = customerName;
        this.adress = adress;
        this.itemsBought = itemsBought;
        this.totalPrice = totalPrice;

    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(String itemsBought) {
        this.itemsBought = itemsBought;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

