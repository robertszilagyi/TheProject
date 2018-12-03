package com.fasttrackit;


import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Store;
import com.fasttrackit.dto.StoreDTO;
import com.fasttrackit.service.StoreService;

import java.util.List;

public class StoreIntegrationTest
{


private StoreService storeService;



public void testService()
{
    Store store = new Store();
    store.setName("");
    store.setAdress("");


    Product product1 = new Product();
    product1.setProductName("Keyboard");
    product1.setPrice("30.5");
    product1.setStock("25");
    product1.setManufacturer("Corasair");

    Product product2 = new Product();
    product2.setProductName("Mouse");
    product2.setPrice("15.5");
    product2.setStock("10");
    product2.setManufacturer("Razer");

    store.getProducts().add(product1);
    store.getProducts().add(product2);
    storeService.saveStore(store);

    List<StoreDTO> stores = storeService.getStores();
    System.out.println("."+stores.get(0));
}

}
