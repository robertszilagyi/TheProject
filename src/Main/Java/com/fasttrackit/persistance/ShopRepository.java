package com.fasttrackit.persistance;

import com.fasttrackit.domain.Store;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepository extends PagingAndSortingRepository<Store, Long>
{

}
