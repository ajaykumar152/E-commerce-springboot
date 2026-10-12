package com.e_commerce.site.repository;

import com.e_commerce.site.members.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByCustomerUsername(String username);
}
