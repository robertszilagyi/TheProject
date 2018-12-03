package com.fasttrackit.service;

import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Store;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.dto.StoreDTO;
import com.fasttrackit.persistance.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service

public class StoreService
{
    @Autowired
    private StoreRepository storeRepository;

    @Transactional
    public void saveStore(Store store) {
        if (store.getName() == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (store.getAdress() == null) {
            throw new IllegalArgumentException("Adress can not be null");

        }
        try {
            storeRepository.save(store);
        } catch (Exception e) {
            System.out.println("Error when saving store" + e);
        }
    }

    @Transactional
    public List<StoreDTO> getStores() {
        Iterator<Store> iterator =
                storeRepository.findAll().iterator();

        List<StoreDTO> list = new ArrayList<>();

        while (iterator.hasNext()) {
            Store store = iterator.next();

            StoreDTO storeDTO = new StoreDTO();
            storeDTO.setName(store.getName());
            storeDTO.setId(store.getId());

            List<Product> products = store.getProducts();
            int numberOfPRoducts = 0;
            while (numberOfPRoducts < 5 && products.size() >= 5) {
                Product product = products.get(numberOfPRoducts);
                ProductDTO productDTO = new ProductDTO();

                productDTO.setId(product.getId());
                productDTO.setProductName(product.getProductName());
                productDTO.setPrice(product.getPrice());

                storeDTO.getFirstElements().add(productDTO);
                numberOfPRoducts++;

            }
            list.add(storeDTO);

        }
        return list;
    }
}