package com.fooddrop.FoodDrop.repository;

import com.fooddrop.FoodDrop.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);

}
