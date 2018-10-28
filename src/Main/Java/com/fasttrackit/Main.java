package com.fasttrackit;



public class Main
{

    public static void main(String[] args)
    {

            Orders customer1 = new Orders("Andrew", "Alea Florilor 45", "pcCase, cooler");
        System.out.println("Customer name: " + customer1.getCustomerName()+  " Adress: " +customer1.getAdress() + "Items bought: "  + customer1.getItemsBought()+ "." + "Total price:" + customer1.getTotalPrice());

        Orders customer2 = new Orders("Dan", "30 Decembrie 11", "memory, video card");
        System.out.println("Customer name: " + customer2.getCustomerName()+  " Adress: " +customer2.getAdress() + "Items bought: "  + customer2.getItemsBought()+ "." + "Total price: " + customer2.getTotalPrice());
        }
    }