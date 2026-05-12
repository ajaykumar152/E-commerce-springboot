package com.e_commerce.site.service;

import com.e_commerce.site.members.Customer;

public interface CustomerService {

    boolean addCustomer(Customer customer);
    boolean validateCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
}
