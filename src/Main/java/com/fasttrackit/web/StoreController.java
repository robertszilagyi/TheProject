package com.fasttrackit.web;

import com.fasttrackit.dto.StoreDTO;
import com.fasttrackit.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController


public class StoreController


{
    @Autowired
    private StoreService storeService;


@RequestMapping(path = "/store/{id}", method = RequestMethod.GET)
    public StoreDTO getStore(@PathVariable("id") long id)
{
    return  storeService.getStoreById(id);



}
@RequestMapping(path = "/store", method = RequestMethod.POST)
public void saveStore(@RequestBody StoreDTO store)
{
//    storeService.saveStore(store);

}


@RequestMapping(path = "/store/ {id}", method = RequestMethod.PUT)
public StoreDTO updateStore(@PathVariable long id, @RequestBody StoreDTO dto)
{
    return storeService.updateStore(id, dto);
}


}