package com.fasttrackit;


import com.fasttrackit.domain.Cart;
import com.fasttrackit.domain.CustomerInformation;
import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Store;
import com.fasttrackit.persistance.CartRepository;
import com.fasttrackit.persistance.CustomerInformationRepository;
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
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository repository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerInformationRepository customerInformationRepository;


    @Test
    public void testService() {
        Store store = new Store();
        store.setName("Fruit's Store");
        store.setDescription("Fresh fruits every day !");
        store.setAdress("Strada Plevnei, nr.15 ");


        List<Product> products = new ArrayList<>();


        Product product1 = new Product();
        product1.setProductName("Oranges");
        product1.setImagePath("img/Oranges.jpg");
        product1.setPrice(2);
        products.add(product1);
        store.setProducts(products);


        Product product2  = new Product();
        product2.setProductName("Apples");
        product2.setImagePath("img/Apples.jpg");
        product2.setPrice(1.5);
        products.add(product2);
        store.setProducts(products);



        Product product3  = new Product();
        product3.setProductName("Bananas");
        product3.setPrice(3);
        product3.setImagePath("img/Bananas.jpg");
        products.add(product3);
        store.setProducts(products);



        Product product4  = new Product();
        product4.setProductName("Blackberry");
        product4.setImagePath("img/Blackberry.jpg");
        product4.setPrice(4);
        products.add(product4);
        store.setProducts(products);



        Product product5  = new Product();
        product5.setProductName("Blue Grapes");
        product5.setImagePath("img/BlueGrapes.jpg");
        product5.setPrice(2.5);
        products.add(product5);
        store.setProducts(products);



        Product product6  = new Product();
        product6.setProductName("White Grapes");
        product6.setImagePath("img/WhiteGrapes.jpg");
        product6.setPrice(3);
        products.add(product6);
        store.setProducts(products);




        Product product7  = new Product();
        product7.setProductName("Grapefrut");
        product7.setImagePath("img/Grepfrut.jpg");
        product7.setPrice(4);
        products.add(product7);
        store.setProducts(products);


        Product product8  = new Product();
        product8.setProductName("Kiwi");
        product8.setImagePath("img/kiwi2.jpg");
        product8.setPrice(2.5);
        products.add(product8);
        store.setProducts(products);


        Product product9  = new Product();
        product9.setProductName("Mango");
        product9.setImagePath("img/Mango.jpg");
        product9.setPrice(4.5);
        products.add(product9);
        store.setProducts(products);


        Product product10  = new Product();
        product10.setProductName("Pineapple");
        product10.setImagePath("img/Pineapple.jpg");
        product10.setPrice(3.75);
        products.add(product10);
        store.setProducts(products);


        Product product11  = new Product();
        product11.setProductName("Pom fruit");
        product11.setImagePath("img/PomFruit.jpg");
        product11.setPrice(2.45);
        products.add(product11);
        store.setProducts(products);

        Product product12  = new Product();
        product12.setProductName("Strawberries");
        product12.setImagePath("img/Strawberry.jpg");
        product12.setPrice(2.45);
        products.add(product12);
        store.setProducts(products);


        Product product13  = new Product();
        product13.setProductName("Watermelon");
        product13.setImagePath("img/Watermelon.jpg");
        product13.setPrice(1);
        products.add(product13);
        store.setProducts(products);

        Product product14  = new Product();
        product14.setProductName("Avocado");
        product14.setImagePath("img/Avocado.jpg");
        product14.setPrice(2.75);
        products.add(product14);
        store.setProducts(products);

        repository.save(store);



        CustomerInformation customerInformation = new CustomerInformation();

        customerInformationRepository.save(customerInformation);



    }


}

