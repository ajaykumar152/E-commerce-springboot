package com.e_commerce.site.implementation;

import com.e_commerce.site.members.Customer;
import com.e_commerce.site.repository.CustomerRepository;
import com.e_commerce.site.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImplementaion implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(Customer customer) {
        Customer isCustomer = customerRepository.findByCustomerUsername(customer.getCustomerUsername());
        if(isCustomer == null) {
            customerRepository.save(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validateCustomer(Customer customer) {
        Customer iscustomer = customerRepository.findByCustomerUsername(customer.getCustomerUsername());

        if(iscustomer == null || iscustomer.getPassword().equals(customer.getPassword())){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Customer iscustomer = customerRepository.findByCustomerUsername(customer.getCustomerUsername());

        if(iscustomer != null){
            iscustomer.setCustomerUsername(customer.getCustomerUsername());
            iscustomer.setPhone(customer.getPhone());
            iscustomer.setEmail(customer.getEmail());
            customerRepository.save(iscustomer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
       try {
           customerRepository.delete(customer);
           return true;
       } catch (Exception e) {
           return false;
        }
    }
}
