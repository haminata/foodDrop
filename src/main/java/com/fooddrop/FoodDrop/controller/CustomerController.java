package com.fooddrop.FoodDrop.controller;

import com.fooddrop.FoodDrop.model.Customer;
import com.fooddrop.FoodDrop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewCustommer(@RequestBody Customer customerDetails) {
        customerRepository.save(customerDetails);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        // This returns a JSON or XML with the users
        return customerRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                                   @RequestBody Customer customerDetails){
        return customerRepository.findById(id)
                .map(oldCustomerDetails ->{
                            oldCustomerDetails.setFirstName(customerDetails.getFirstName());
                            oldCustomerDetails.setLastName(customerDetails.getLastName());
                            oldCustomerDetails.setAddress(customerDetails.getAddress());
                            oldCustomerDetails.setPostCode(customerDetails.getPostCode());
                            oldCustomerDetails.setPassword(customerDetails.getPassword());
                            oldCustomerDetails.setRole(customerDetails.getRole());
                            oldCustomerDetails.setUsername(customerDetails.getUsername());
                            oldCustomerDetails.setPassword(customerDetails.getPassword());
                            oldCustomerDetails.setEmail(customerDetails.getEmail());

                            Customer updatedCustomer = customerRepository.save(oldCustomerDetails);
                            return ResponseEntity.ok().body(updatedCustomer);
                }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        return customerRepository.findById(id)
                .map(customerRecord ->{
                    customerRepository.deleteById(id);
                    return ResponseEntity.ok().build();

        }).orElse(ResponseEntity.notFound().build());

    }

}
