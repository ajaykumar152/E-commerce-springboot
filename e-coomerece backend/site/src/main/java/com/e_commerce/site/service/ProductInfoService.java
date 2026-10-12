package com.e_commerce.site.service;

import com.e_commerce.site.members.ProductInfo;
import com.e_commerce.site.members.ProductInfoProducts;
import com.e_commerce.site.members.Products;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductInfoService {

    ProductInfo getProductInfo(@RequestParam String productId);
    boolean addProductInfo(ProductInfo productInfo);
    List<Products> getProductsList();
}
