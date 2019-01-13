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
    public void saveStore(Store store)
    {
        if (store.getName() == null)
        {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (store.getAdress() == null)
        {
            throw new IllegalArgumentException("Adress can not be null");

        }
        Store convert = convert(store);
        try {
            storeRepository.save(store);
        } catch (Exception e)
        {
            System.out.println("Error when saving store" + e);
        }
    }

    @Transactional
    public List<StoreDTO> getStores()
    {
        Iterator<Store> iterator =
                storeRepository.findAll().iterator();

        List<StoreDTO> list = new ArrayList<>();

        while (iterator.hasNext())
        {
            Store store = iterator.next();

            StoreDTO storeDTO = new StoreDTO();
            storeDTO.setName(store.getName());
            storeDTO.setId(store.getId());

            List<Product> products = store.getProducts();
            int numberOfPRoducts = 0;
            while (numberOfPRoducts < 5 && products.size() >= 5)
            {
                Product product = products.get(numberOfPRoducts);
                ProductDTO productDTO = new ProductDTO();

                productDTO.setId(product.getId());
                productDTO.setProductName(product.getProductName());


                storeDTO.getFirstElements().add(productDTO);
                numberOfPRoducts++;

            }
            list.add(storeDTO);

        }
        return list;
    }

    private StoreDTO convertToDto(Store store)
{
    StoreDTO storeDTO = new StoreDTO();
    storeDTO.setName(store.getName());
    storeDTO.setId(store.getId());
    storeDTO.setDescription(store.getDescription());
    return storeDTO;
}

    private Store convert(Store store)
    {
        Store store1 = new Store();
        store.setName(store.getName());
        store.setId(store.getId());
        store.setDescription(store.getDescription());
        return store1;
    }

    public StoreDTO getStoreById(long id)
    {
        Store one = storeRepository.findOne(id);
       if (one == null)
       {
           throw new IllegalArgumentException("The id is not valid");
       }
       return null;
    }

    public StoreDTO updateStore(long id, StoreDTO dto)
    {
        Store store = storeRepository.findOne(id);
        store.setDescription(dto.getDescription());
        store.setName(dto.getName());
        Store save = storeRepository.save(store);

        return convertToDto(save);
    }


}