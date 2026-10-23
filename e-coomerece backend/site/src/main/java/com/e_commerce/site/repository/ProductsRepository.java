package com.e_commerce.site.repository;

import com.e_commerce.site.members.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import com.e_commerce.site.DTO.SendHomePageProductsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, String> {

    Products findProductsById(String productId);

   @Query(
        value = "SELECT p.id AS id, p.productName AS productName, p.price AS price, p.productLink AS productLink FROM Products p",
        countQuery = "SELECT count(p.id) FROM Products p"
    )
    Page<SendHomePageProductsDTO> findAllBy(Pageable pageable);

    @Query(
        value = "SELECT p.id AS id, p.productName AS productName, p.price AS price, p.productLink AS productLink FROM Products p WHERE p.productType = :productType",
        countQuery = "SELECT count(p.id) FROM Products p WHERE p.productType = :productType"
    )
    Page<SendHomePageProductsDTO> findAllByProductType(@Param("productType") String productType, Pageable pageable);
}
