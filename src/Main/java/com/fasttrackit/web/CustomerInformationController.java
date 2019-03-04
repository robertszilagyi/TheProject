package com.fasttrackit.web;

import com.fasttrackit.dto.CustomerInformationDTO;
import com.fasttrackit.service.CustomerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerInformationController
{
    @Autowired
    private CustomerInformationService customerInformationService;

    @RequestMapping(path = "/customerInformation/(id)" , method = RequestMethod.GET)
    public CustomerInformationDTO getCustomerInformation (@PathVariable("id") long id)
    {
        return customerInformationService.getCustomerInformationById(id);
    }

    @RequestMapping(path = "/customerInformation", method = RequestMethod.POST)
    public void saveCustomerInformation (@RequestBody CustomerInformationDTO customerInformationDTO)
    {
     //   customerInformationService.saveCustomerInformation(customerInformationDTO)
    }

    @RequestMapping (path = "/customerInformation/(id)", method = RequestMethod.PUT)
    public CustomerInformationDTO updateCustomerInformation (@PathVariable long id, @RequestBody CustomerInformationDTO dto)
    {
        return customerInformationService.updateCustomerInformation(id, dto);
    }

    @RequestMapping(path = "/customerInformation" , method = RequestMethod.GET)
    public CustomerInformationDTO getCustomerInformationByEmailAndPassword (@RequestParam("email") String email, @RequestParam("password") String password)
    {
        return customerInformationService.getCustomerInformationByEmailAndPassword(email, password);
    }
}
