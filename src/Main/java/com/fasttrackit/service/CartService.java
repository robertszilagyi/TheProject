package com.fasttrackit.service;


import com.fasttrackit.domain.Cart;
import com.fasttrackit.domain.Product;
import com.fasttrackit.dto.CartDTO;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.persistance.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class CartService
{
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void saveCart(Cart cart)
    {
        if (cart.getCustomerInformation() == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }

        try {
            cartRepository.save(cart);

        }
        catch (Exception e)
        {
            System.out.println("Error when saving cart" +e);
        }
    }
    @Transactional
    public List<CartDTO> getCart()
    {
        Iterator<Cart> iterator = cartRepository.findAll().iterator();

        List<CartDTO> list = new ArrayList<>();

        while (iterator.hasNext())
        {
            Cart cart = iterator.next();

            CartDTO cartDTO = new CartDTO();
            cartDTO.setCustomerInformation(cart.getCustomerInformation());
            cartDTO.setId(cart.getId());

            List<Product> products = cart.getProducts();

            int numberOfProducts = 0;
            while (numberOfProducts < 5 && products.size() >= 5);
            {
                Product product = products.get(numberOfProducts);
                ProductDTO productDTO = new ProductDTO();

                productDTO.setId(product.getId());
                productDTO.setProductName(product.getProductName());

                numberOfProducts++;
            }
            list.add(cartDTO);
        }
        return list;
    }
    private CartDTO convertToDTO( Cart cart)
    {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCustomerInformation(cart.getCustomerInformation());
        cartDTO.setId(cart.getId());
        return cartDTO;
    }
     private Cart cart(Cart cart)
     {
         Cart cart1 = new Cart();
         cart.setCustomerInformation(cart.getCustomerInformation());
         cart.setId(cart.getId());
         return cart1;
     }

     public CartDTO getCartById ( long id)
     {
         Cart one = cartRepository.findOne(id);
         if (one == null)
         {
             throw new IllegalArgumentException("This id is not valid");

         }
         return null;
     }

     public CartDTO updateCart(long id, CartDTO dto)
     {
         Cart cart = cartRepository.findOne(id);
         cart.setCustomerInformation(dto.getCustomerInformation());
         Cart save = cartRepository.save(cart);

         return convertToDTO(save);
     }
}
