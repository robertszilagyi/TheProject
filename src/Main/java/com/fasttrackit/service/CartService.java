package com.fasttrackit.service;


import com.fasttrackit.domain.Cart;
import com.fasttrackit.domain.CustomerInformation;
import com.fasttrackit.domain.Product;
import com.fasttrackit.dto.CartDTO;
import com.fasttrackit.dto.CustomerInformationDTO;
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

//    @Transactional
    public void saveCart(CartDTO cartDTO)
    {
        if (cartDTO.getCustomerInformation() == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }

        try {
            Cart cart = converFromDTO(cartDTO);

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

            CartDTO cartDTO = convertToDTO(cart);


            list.add(cartDTO);
        }
        return list;
    }
    private CartDTO convertToDTO( Cart cart)
    {
        CartDTO cartDTO = new CartDTO();
        CustomerInformationDTO customerInformationDTO = convertToCustomerInformationDTO(cart);

        List<ProductDTO> productDTOS =  new ArrayList<>();
        for (Product product: cart.getProducts())
        {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(product.getProductName());
            productDTO.setImagePath(product.getImagePath());
            productDTO.setPrice(product.getPrice());
            productDTO.setId(product.getId());

            productDTOS.add(productDTO);
        }
        cartDTO.setProducts(productDTOS);
        cartDTO.setCustomerInformation(customerInformationDTO);
        cartDTO.setId(cart.getId());
        return cartDTO;
    }

    private CustomerInformationDTO convertToCustomerInformationDTO(Cart cart) {
        CustomerInformationDTO customerInformationDTO = new CustomerInformationDTO();
        customerInformationDTO.setId(cart.getCustomerInformation().getId());
        customerInformationDTO.setUsername(cart.getCustomerInformation().getUsername());
        customerInformationDTO.setPassword(cart.getCustomerInformation().getPassword());
        customerInformationDTO.setEmail(cart.getCustomerInformation().getEmail());
        customerInformationDTO.setPhoneNumber(cart.getCustomerInformation().getPhoneNumber());
        customerInformationDTO.setName(cart.getCustomerInformation().getName());
        customerInformationDTO.setFirstName(cart.getCustomerInformation().getFirstName());
        return customerInformationDTO;
    }

    private Cart converFromDTO(CartDTO cartDTO)
     {
         Cart cart = new Cart();
         CustomerInformation customerInformation = convertCustomerInformationFromDTO(cartDTO);
         cart.setCustomerInformation(customerInformation);
         cart.setId(cartDTO.getId());

         List<Product> products = new ArrayList<>();
         for (ProductDTO productDTO: cartDTO.getProducts())
         {
             Product product = new Product();
             product.setImagePath(productDTO.getImagePath());
             product.setProductName(productDTO.getProductName());
             product.setPrice(productDTO.getPrice());
             product.setId(productDTO.getId());

             products.add(product);
         }

         cart.setProducts(products);


         return cart;
     }

    private CustomerInformation convertCustomerInformationFromDTO(CartDTO cartDTO) {
        CustomerInformation customerInformation = new CustomerInformation();
        customerInformation.setUsername(cartDTO.getCustomerInformation().getUsername());
        customerInformation.setPassword(cartDTO.getCustomerInformation().getPassword());
        customerInformation.setEmail(cartDTO.getCustomerInformation().getEmail());
        customerInformation.setPhoneNumber(cartDTO.getCustomerInformation().getPhoneNumber());
        customerInformation.setId(cartDTO.getCustomerInformation().getId());
        customerInformation.setFirstName(cartDTO.getCustomerInformation().getFirstName());
        customerInformation.setName(cartDTO.getCustomerInformation().getName());
        return customerInformation;
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
         CustomerInformation customerInformation = convertCustomerInformationFromDTO(dto);

         cart.setCustomerInformation(customerInformation);
         Cart save = cartRepository.save(cart);

         return convertToDTO(save);
     }
}
