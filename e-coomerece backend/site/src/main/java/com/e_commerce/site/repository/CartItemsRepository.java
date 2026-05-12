package com.e_commerce.site.repository;

import com.e_commerce.site.members.CartItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

    CartItems findByCartIdAndProductsId(Long cartId, String productId);
    List<CartItems> findByCart_Id(Long cartId);
    Page<CartItems> findAllByCart_Id(Long cartId, Pageable pageable);
}
