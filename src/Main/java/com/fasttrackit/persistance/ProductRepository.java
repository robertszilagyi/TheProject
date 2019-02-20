package com.fasttrackit.persistance;

import com.fasttrackit.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>
{

}
