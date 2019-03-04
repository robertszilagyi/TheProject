package com.fasttrackit.persistance;


import com.fasttrackit.domain.CustomerInformation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerInformationRepository extends PagingAndSortingRepository<CustomerInformation, Long>
{

    CustomerInformation findByEmailAndPassword(String email, String password);

}
