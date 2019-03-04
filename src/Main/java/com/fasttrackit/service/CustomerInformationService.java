package com.fasttrackit.service;

import com.fasttrackit.domain.CustomerInformation;
import com.fasttrackit.dto.CustomerInformationDTO;
import com.fasttrackit.persistance.CustomerInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerInformationService {
    @Autowired
    private CustomerInformationRepository customerInformationRepository;

    @Transactional
    public void saveCustomerInformation(CustomerInformationDTO customerInformationDTO)
    {
//        if (customerInformation.getFirstName() == null) {
//            throw new IllegalArgumentException("First name cannot be null");
//        }
//        if (customerInformation.getName() == null) {
//            throw new IllegalArgumentException("Name cannot be null");
//        }
//        if (customerInformation.getEmail() == null) {
//            throw new IllegalArgumentException("Email cannot be null");
//        }
//        if (customerInformation.getPhoneNumber() == null) {
//            throw new IllegalArgumentException("Phone number cannot be null");
//        }
//        if (customerInformation.getPassword() == null) {
//            throw new IllegalArgumentException("Password cannot be null");
//        }
        try {
            CustomerInformation customerInformation =convert(customerInformationDTO);
            customerInformationRepository.save(customerInformation);
        } catch (Exception e) {
            System.out.println("Error when saving customerInformation" + e);
        }

    }

    private CustomerInformationDTO convertToDto(CustomerInformation customerInformation) {
        CustomerInformationDTO customerInformationDTO = new CustomerInformationDTO();
      //  customerInformationDTO.setFirstName(customerInformation.getFirstName());
      //  customerInformationDTO.setName(customerInformation.getName());
        customerInformationDTO.setEmail(customerInformation.getEmail());
       // customerInformationDTO.setPhoneNumber(customerInformation.getPhoneNumber());
       // customerInformationDTO.setUsername(customerInformation.getUsername());
        customerInformationDTO.setPassword(customerInformation.getPassword());
        customerInformationDTO.setId(customerInformation.getId());
        return customerInformationDTO;
    }

    private CustomerInformation convert(CustomerInformationDTO customerInformationDTO) {
        CustomerInformation customerInformation1 = new CustomerInformation();
       // customerInformation1.setFirstName(customerInformationDTO.getFirstName());
       // customerInformation1.setName(customerInformationDTO.getName());
       // customerInformation1.setPhoneNumber(customerInformationDTO.getPhoneNumber());
        customerInformation1.setEmail(customerInformationDTO.getEmail());
       // customerInformation1.setUsername(customerInformationDTO.getUsername());
       customerInformation1.setPassword(customerInformationDTO.getPassword());
        customerInformation1.setId(customerInformationDTO.getId());
        return customerInformation1;
    }

    public CustomerInformationDTO getCustomerInformationById(long id) {
        CustomerInformation one = customerInformationRepository.findOne(id);
        if (one == null) {
            throw new IllegalArgumentException("The id is not valid");
        }
        return convertToDto(one);
    }

    public CustomerInformationDTO getCustomerInformationByEmailAndPassword(String email, String password) {
        CustomerInformation customerInformation = customerInformationRepository.findByEmailAndPassword(email, password);
        if (customerInformation == null) {
            throw new IllegalArgumentException("The customer with email " + email + " was not found.");
        }
        return convertToDto(customerInformation);

    }

    public CustomerInformationDTO updateCustomerInformation(long id, CustomerInformationDTO dto) {
        CustomerInformation customerInformation = customerInformationRepository.findOne(id);
      //  customerInformation.setFirstName(dto.getFirstName());
      //  customerInformation.setName(dto.getName());
      //  customerInformation.setPhoneNumber(dto.getPhoneNumber());
        customerInformation.setEmail(dto.getEmail());
        customerInformation.setPassword(dto.getPassword());
      //  customerInformation.setUsername(dto.getUsername());

        CustomerInformation save = customerInformationRepository.save(customerInformation);

        return convertToDto(save);
    }

}
