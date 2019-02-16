package com.fasttrackit;


import com.fasttrackit.domain.Cart;
import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Store;
import com.fasttrackit.persistance.CartRepository;
import com.fasttrackit.persistance.ProductRepository;
import com.fasttrackit.persistance.StoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StoreApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class StoreIntegrationTest
{
    @Autowired
    ProductRepository productRepository;

    @Autowired
private StoreRepository repository;
    @Autowired
    CartRepository cartRepository;


    @Test
    public void testService() {
        Store store = new Store();
        store.setName("Phone's Store");
        store.setDescription("Best deals every day !");
        store.setAdress("Strada Plevnei, nr.15 ");

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductName("iPhone XS");
        product1.setStock(1000);
        product1.setManufacturer("Apple");
        product1.setPrice(1000);
        products.add(product1);
        store.setProducts(products);


        Product product2  = new Product();
        product2.setProductName("Samsung galaxy S9");
        product2.setStock(1000);
        product2.setManufacturer("Samsung");
        product2.setPrice(650);
        products.add(product2);
        store.setProducts(products);



        Product product3  = new Product();
        product3.setProductName("Samsung galaxy S9 Plus");
        product3.setStock(1000);
        product3.setManufacturer("Samsung");
        product3.setPrice(800);
        products.add(product3);
        store.setProducts(products);



        Product product4  = new Product();
        product4.setProductName("Samsung galaxy S8");
        product4.setStock(300);
        product4.setManufacturer("Samsung");
        product4.setPrice(400);
        products.add(product4);
        store.setProducts(products);



        Product product5  = new Product();
        product5.setProductName("Samsung galaxy S8 Plus");
        product5.setStock(100);
        product5.setManufacturer("Samsung");
        product5.setPrice(500);
        products.add(product5);
        store.setProducts(products);



        Product product6  = new Product();
        product6.setProductName("Iphone Xs Max");
        product6.setStock(1000);
        product6.setManufacturer("Apple");
        product6.setPrice(1100);
        products.add(product6);
        store.setProducts(products);


        Product product7  = new Product();
        product7.setProductName("Iphone X");
        product7.setStock(200);
        product7.setManufacturer("Apple");
        product7.setPrice(800);
        products.add(product7);
        store.setProducts(products);


        Product product8  = new Product();
        product8.setProductName("Iphone 8");
        product8.setStock(500);
        product8.setManufacturer("Apple");
        product8.setPrice(600);
        products.add(product8);
        store.setProducts(products);


        Product product9  = new Product();
        product9.setProductName("Iphone 8 Plus");
        product9.setStock(500);
        product9.setManufacturer("Apple");
        product9.setPrice(750);
        products.add(product9);
        store.setProducts(products);


        Product product10  = new Product();
        product10.setProductName("Iphone 7");
        product10.setStock(200);
        product10.setManufacturer("Apple");
        product10.setPrice(450);
        products.add(product10);
        store.setProducts(products);


        Product product11  = new Product();
        product11.setProductName("Iphone 7 Plus");
        product11.setStock(200);
        product11.setManufacturer("Apple");
        product11.setPrice(500);
        products.add(product11);
        store.setProducts(products);


        Product product12  = new Product();
        product12.setProductName("Iphone XR");
        product12.setStock(1000);
        product12.setManufacturer("Apple");
        product12.setPrice(750);
        products.add(product12);
        store.setProducts(products);


        Product product13  = new Product();
        product13.setProductName("Iphone SE");
        product13.setStock(100);
        product13.setManufacturer("Apple");
        product13.setPrice(300);
        products.add(product13);
        store.setProducts(products);

        repository.save(store);
    }

    @Test
    public void TestSave2()
    {
        Iterable<Product> allProducts = productRepository.findAll();
        Cart cart = new Cart();

        List<Product> products = makeCollection(allProducts);
        cart.setProducts(products);

        cart.computeTotalPrice();
        cartRepository.save(cart);
    }

    public static <E> List <E> makeCollection(Iterable<E> iter)
    {
        List<E> list = new ArrayList<>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }
}

