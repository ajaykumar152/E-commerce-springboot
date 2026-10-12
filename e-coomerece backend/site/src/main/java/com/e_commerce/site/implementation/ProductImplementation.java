package com.e_commerce.site.implementation;

import com.e_commerce.site.CloudinaryService;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.repository.ProductsRepository;
import com.e_commerce.site.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProductImplementation implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public boolean addProduct(Double price, String name, String type, MultipartFile file) {
        try {
            String[] details = cloudinaryService.upload(file);
            Products product = new Products();
            product.setProductLink(details[0]);
            product.setId(details[1]);
            product.setProductName(name);
            product.setPrice(price);
            product.setProductType(type);
            productsRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeProduct(Products products) {
        try {
            productsRepository.delete(products);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page<Products> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productsRepository.findAll(pageable);
    }
}
