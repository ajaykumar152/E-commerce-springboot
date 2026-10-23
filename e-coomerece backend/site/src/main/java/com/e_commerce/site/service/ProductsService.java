package com.e_commerce.site.service;

import com.e_commerce.site.members.Products;
import com.e_commerce.site.DTO.GetNewProductDTO;
import org.springframework.data.domain.Page;
import com.e_commerce.site.DTO.SendHomePageProductsDTO;

import java.util.List;

public interface ProductsService {

    boolean addProduct(GetNewProductDTO productDTO);
    boolean removeProduct(Products products);
    Page<SendHomePageProductsDTO> getProducts(int page, int size);
    Products getProductById(String productId);
    Page<SendHomePageProductsDTO> getProductsList();
}
