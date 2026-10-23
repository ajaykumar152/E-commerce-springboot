package com.e_commerce.site.controller;

import com.e_commerce.site.implementation.ProductImplementation;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.DTO.GetNewProductDTO;
import com.e_commerce.site.DTO.SendHomePageProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "${app.front-end.url}")
public class ProductController {

    @Autowired
    private ProductImplementation productImplementation;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody GetNewProductDTO productDTO) {
        boolean result = productImplementation.addProduct(productDTO);

        if (result) {
            return new ResponseEntity<>("Product added", HttpStatus.OK);
        }  else {
            return new ResponseEntity<>("Product not added", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody Products product) {
        boolean isRemoved = productImplementation.removeProduct(product);

        if (isRemoved) {
            return new ResponseEntity<>("Product removed", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not removed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Page<SendHomePageProductsDTO>> getProducts(@RequestParam int page, @RequestParam int size) {
        try {
            Page<SendHomePageProductsDTO> products = productImplementation.getProducts(page, size);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info/{productId}")
    public ResponseEntity<Products> getProductInfo(@PathVariable String productId) {
        try {
            Products product = productImplementation.getProductById(productId);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Page<SendHomePageProductsDTO>> getProductsList() {
        try{
            Page<SendHomePageProductsDTO> products =  productImplementation.getProductsList();
            return new ResponseEntity<>(products, HttpStatus.OK);
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }   
    }
}
