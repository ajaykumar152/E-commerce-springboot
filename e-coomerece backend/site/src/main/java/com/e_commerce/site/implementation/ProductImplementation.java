package com.e_commerce.site.implementation;

import com.e_commerce.site.CloudinaryService;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.DTO.GetNewProductDTO;
import com.e_commerce.site.DTO.SendHomePageProductsDTO;
import com.e_commerce.site.repository.ProductsRepository;
import com.e_commerce.site.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Component
public class ProductImplementation implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public boolean addProduct(GetNewProductDTO productDTO) {
        String name = productDTO.getProductName();
        Double price = productDTO.getPrice();   
        String type = productDTO.getProductType();
        MultipartFile file = productDTO.getProductImage();
        String description = productDTO.getProductDescription();

        try {
            String[] details = cloudinaryService.upload(file);
            Products product = new Products();
            product.setProductLink(details[0]);
            product.setId(details[1]);
            product.setProductName(name);
            product.setPrice(price);
            product.setProductType(type);
            product.setProductDescription(description);
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
    public Page<SendHomePageProductsDTO> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productsRepository.findAllBy(pageable);
    }

    @Override
    public Products getProductById(String productId) {
        return productsRepository.findById(productId).orElse(null);
    }

    @Override
    public Page<SendHomePageProductsDTO> getProductsList() {
        Pageable pageable = PageRequest.of(0, 5);
        return productsRepository.findAllByProductType("phone", pageable);
    }
}
