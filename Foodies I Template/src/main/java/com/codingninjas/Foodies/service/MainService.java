package com.codingninjas.Foodies.service;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.CustomerRepository;
import com.codingninjas.Foodies.repository.RatingRepository;
import com.codingninjas.Foodies.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RatingRepository ratingRepository;
    public void addRestaurent(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void addCustomer (Customer customer){
        customerRepository.save(customer);
    }

    public void addRating(Rating rating, int customerId, String restaurantName) {

        Customer customer = customerRepository.findById(customerId).get();
        List<Rating> ratingList = customer.getRatings();
        ratingList.add(rating);
        customer.setRatings(ratingList);
        List<Restaurant> restaurantList = customer.getVisitedRestaurants();

        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        List<Rating> ratingList1 = restaurant.getRatings();
        ratingList1.add(rating);
        restaurant.setRatings(ratingList1);
        rating.setRestaurant(restaurant);
        restaurantList.add(restaurant);
        customer.setVisitedRestaurants(restaurantList);
        ratingRepository.save(rating);
        restaurantRepository.save(restaurant);
        customerRepository.save(customer);


    }

    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerListOnRest(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        return customerRepository.findByVisitedRestaurants(restaurant);
    }

    public List<Customer> getCustomerListOnRating(String restaurantName, double rating) {
       List<Customer> l1 = getCustomerListOnRest(restaurantName);
       List<Customer> l2 = new ArrayList<>();
       for(Customer c:l1){
           List<Rating> r =c.getRatings();
           for (Rating r1:r){
               if(r1.getRating()>rating){
                   l2.add(c);
                   break;
               }
           }
       }
        return l2;
    }

    public double getAvgRating(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        List<Rating> a= restaurant.getRatings();
        double sum =0;
        for(Rating r:a){
            sum=sum+r.getRating();
        }

        return sum/a.size();
    }
}
