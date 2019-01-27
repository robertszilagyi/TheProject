package com.fasttrackit;


import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Store;
import com.fasttrackit.dto.StoreDTO;
import com.fasttrackit.persistance.StoreRepository;
import com.fasttrackit.service.StoreService;
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
private StoreRepository repository;


    @Test
    public void testService() {
        Store store = new Store();
        store.setName("PCStore");
        store.setAdress("Strada Plevnei, nr.15 ");

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductName("Keyboard");
        product1.setStock("25");
        product1.setManufacturer("Corasair");
        products.add(product1);

        store.setProducts(products);
        repository.save(store);


    }
}
