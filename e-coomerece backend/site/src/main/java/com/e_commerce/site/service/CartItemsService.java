package com.e_commerce.site.service;

import com.e_commerce.site.members.Cart;
import com.e_commerce.site.members.CartItems;
import com.e_commerce.site.members.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartItemsService {

    boolean addProductToCartItems(Cart cart, String productId);
    Page<CartItems> getAllCartItems(Long cartId, int page, int pageSize);
    boolean addPlusOne(Cart cart, String productId);
    boolean subMinusOne(Cart cart, String productId);
}
