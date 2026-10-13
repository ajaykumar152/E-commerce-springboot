package com.e_commerce.site.controller;

import com.e_commerce.site.implementation.ProductInfoServiceImplementation;
import com.e_commerce.site.members.ProductInfo;
import com.e_commerce.site.members.ProductInfoProducts;
import com.e_commerce.site.members.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
@CrossOrigin(origins = "${app.front-end.url}")
public class ProductInfoController {

    @Autowired
    private ProductInfoServiceImplementation productInfoService;

    @GetMapping
    public ResponseEntity<ProductInfo> getProductInfo(@RequestParam String productId) {
        ProductInfo productInfo = productInfoService.getProductInfo(productId);
        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProductsList() {
        List<Products> products =  productInfoService.getProductsList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
