package com.e_commerce.site.controller;

import com.e_commerce.site.implementation.CustomerServiceImplementaion;
import com.e_commerce.site.members.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "${app.front-end.url}")
public class CustomerController {

    @Autowired
    private CustomerServiceImplementaion customerServiceImplementaion;

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        boolean customerCreated = customerServiceImplementaion.addCustomer(customer);

        if(customerCreated){
            return new ResponseEntity<>("Customer added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("username exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        boolean customerUpdated = customerServiceImplementaion.updateCustomer(customer);

        if(customerUpdated){
            return new ResponseEntity<>("Customer updated", HttpStatus.OK);
        }  else {
            return new ResponseEntity<>("Customer could not be updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer){
        boolean customerDeleted = customerServiceImplementaion.deleteCustomer(customer);

        if(customerDeleted){
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
        }  else {
            return new ResponseEntity<>("Customer could not be deleted", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<String> getCustomer(@RequestBody Customer customer){
        boolean isPresent = customerServiceImplementaion.validateCustomer(customer);

        if(isPresent){
            return new ResponseEntity<>("Customer found", HttpStatus.OK);
        }  else {
            return new ResponseEntity<>("Customer could not be found", HttpStatus.NOT_FOUND);
        }
    }
}
