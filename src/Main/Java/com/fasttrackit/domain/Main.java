package com.fasttrackit.domain;




public class Main {

    public static void main(String[] args)
    {
        Store store = new Store("PcStore");

        ProductCategory peripherals = new ProductCategory("Peripherals");

        Product keyboard = new Product("Apple Magic Keyboard", 50,  peripherals, 10 );

        Product mouse = new Product("Mouse Microsoft Mobile 1850" , 30, peripherals, 10);

        Product speaker = new Product("JBL GO Speaker", 60, peripherals, 11);


        store.getProductCategory().add(peripherals);

        ProductBasket productBasket = new ProductBasket("John");

        productBasket.addProduct(keyboard);
        productBasket.addProduct(mouse);
        productBasket.addProduct(speaker);

        System.out.println("The product basket contains : " + productBasket.getProducts().size()+ " products "  );
        System.out.println("The total price is : " + productBasket.totalPrice()+ " $");

    }
}