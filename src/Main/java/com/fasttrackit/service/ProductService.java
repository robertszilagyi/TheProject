package com.fasttrackit.service;

import com.fasttrackit.domain.Product;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    private void saveProduct(Product product)
    {
        if(product.getProductName() == null)
        {
            throw new IllegalArgumentException("Product name cannot be null");
        }
        try
        {
            productRepository.save(product);
        }
        catch (Exception e)
        {
            System.out.println("Error when saving product" + e);
        }
    }

    @Transactional
    public List<ProductDTO> getProducts()
    {
        Iterator<Product> iterator = productRepository.findAll().iterator();

        List<ProductDTO> list = new ArrayList<>();

        while (iterator.hasNext());
        {
            Product product = iterator.next();

            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(product.getProductName());
            productDTO.setId(product.getId());
            productDTO.setStock(product.getStock());

            int nrOfProducts = 0;

            list.add(productDTO);
        }
        return list;
    }

private ProductDTO convertToDto (Product product)
{
    ProductDTO productDTO = new ProductDTO();
    productDTO.setProductName(product.getProductName());
    productDTO.setId(product.getId());
    productDTO.setPrice(productDTO.getPrice());
    productDTO.setStock(productDTO.getStock());
    return productDTO;
}

private Product convert (ProductDTO productDTO)
{
    Product produc1 = new Product();
    produc1.setProductName(produc1.getProductName());
    produc1.setPrice(produc1.getPrice());
    produc1.setId(produc1.getId());
    produc1.setStock(produc1.getStock());
    return produc1;
}

public  ProductDTO updateProduct( long id, ProductDTO dto)
{
    Product product1 = productRepository.findOne(id);
    product1.setPrice(dto.getPrice());
    product1.setStock(dto.getStock());
    product1.setProductName(dto.getProductName());

    Product save = productRepository.save(product1);

    return convertToDto(save);
}

public ProductDTO getProductById(long id)
{
    Product product = productRepository.findOne(id);
    if (product == null)
    {
        throw new IllegalArgumentException("The id is not valid");
    }
    return null;

}

}


