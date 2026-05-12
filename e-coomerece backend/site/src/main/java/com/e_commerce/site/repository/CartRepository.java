package com.e_commerce.site.repository;

import com.e_commerce.site.members.Cart;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByCustomer_CustomerUsername(String username);
}

