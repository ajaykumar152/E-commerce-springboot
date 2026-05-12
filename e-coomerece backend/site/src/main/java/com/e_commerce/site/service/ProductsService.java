package com.e_commerce.site.service;

import com.e_commerce.site.members.Products;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductsService {

    boolean addProduct(Double price, String name, String type, MultipartFile file);
    boolean removeProduct(Products products);
    Page<Products> getProducts(int page, int size);
}
