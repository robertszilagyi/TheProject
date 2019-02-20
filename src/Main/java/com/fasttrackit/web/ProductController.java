package com.fasttrackit.web;

import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProductController
{
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/product/id", method = RequestMethod.GET)
    public ProductDTO getProduct (@PathVariable("id") long id)
    {
        return productService.getProductById(id);
    }

    @RequestMapping(path = "/product" , method = RequestMethod.POST)
    public void saveProduct(@RequestBody ProductDTO productDTO)
    {

    }


}
