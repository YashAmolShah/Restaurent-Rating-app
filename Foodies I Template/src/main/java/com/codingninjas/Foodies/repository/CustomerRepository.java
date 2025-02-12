package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
    List< Customer > findByVisitedRestaurants(Restaurant restaurant);


//    List< Customer > findByVisitedRestaurantsAndGreaterThanRatings(Restaurant restaurant, double rating);
}
