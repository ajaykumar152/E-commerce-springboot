package com.e_commerce.site.implementation;

import com.e_commerce.site.members.ProductInfo;
import com.e_commerce.site.members.ProductInfoProducts;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.repository.ProductInfoRepository;
import com.e_commerce.site.repository.ProductsRepository;
import com.e_commerce.site.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInfoServiceImplementation implements ProductInfoService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public ProductInfo getProductInfo(String productId) {
        ProductInfo productInfo = productInfoRepository.findByProductId(productId);
        return productInfo;
    }

    @Override
    public boolean addProductInfo(ProductInfo productInfo) {
        return false;
    }

    @Override
    public List<Products> getProductsList() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Products> products = productsRepository.findAll(pageable).getContent();
        return products;
    }
}
