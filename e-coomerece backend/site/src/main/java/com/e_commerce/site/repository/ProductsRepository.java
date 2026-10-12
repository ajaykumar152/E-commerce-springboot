package com.e_commerce.site.repository;

import com.e_commerce.site.members.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, String> {

    Products findProductsById(String productId);
}
