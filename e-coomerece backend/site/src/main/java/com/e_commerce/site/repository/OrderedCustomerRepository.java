package com.e_commerce.site.repository;

import com.e_commerce.site.members.OrderedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedCustomerRepository extends JpaRepository<OrderedCustomer, Long> {

    OrderedCustomer findByCustomer_CustomerUsername(String username);
}
