package com.e_commerce.site.service;

import com.e_commerce.site.DTO.SendCartItemsDTO;

public interface CartService {

    boolean addProductToCart(String user, String productId);
    SendCartItemsDTO getAllCartProducts(String username, int page, int pageSize);
    boolean addPlusOne(String user, String productId);
    boolean subMinusOne(String user, String productId);
}
