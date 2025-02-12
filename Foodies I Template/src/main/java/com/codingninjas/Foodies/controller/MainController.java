package com.codingninjas.Foodies.controller;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    MainService service;

    @PostMapping("/Restaurant/add")
//    @ResponseStatus(HttpStatus.OK)
    public void addRestaurent(@RequestBody Restaurant restaurant){
        service.addRestaurent(restaurant);
    }


    @PostMapping("/Customer/add")
//    @ResponseStatus(HttpStatus.OK)
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @PostMapping("/Rating/{customerId}/add/{restaurantName}")
    public void addRating(@RequestBody Rating rating, @PathVariable int customerId, @PathVariable
                          String restaurantName){
        service.addRating(rating,customerId,restaurantName);
    }

    @GetMapping("/ratings")
    public List<Rating> getAllRating(){
      return   service.getAllRating();
    }
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomer();
    }

    @GetMapping("/customers/restaurant/{restaurantName}")
    public List<Customer> getCustomerList(@PathVariable String restaurantName){
        return service.getCustomerListOnRest(restaurantName);
    }

    @GetMapping("/customers/restaurant/{restaurantName}/{rating}")
    public List<Customer> greaterRating(@PathVariable String restaurantName, @PathVariable double rating)
    {
        return service.getCustomerListOnRating(restaurantName,rating);
    }

    @GetMapping("/restaurant/{restaurantName}/average")
    public double getAvgRest(@PathVariable String restaurantName){
        return service.getAvgRating(restaurantName);
    }
}
