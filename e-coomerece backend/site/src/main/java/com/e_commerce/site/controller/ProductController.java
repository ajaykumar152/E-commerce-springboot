package com.e_commerce.site.controller;

import com.e_commerce.site.implementation.ProductImplementation;
import com.e_commerce.site.members.Products;
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
    public ResponseEntity<String> addProduct(@RequestParam Double price, @RequestParam String name, @RequestParam String type, @RequestParam MultipartFile image) {
        boolean result = productImplementation.addProduct(price, name, type, image);

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
    public ResponseEntity<Page<Products>> getProducts(@RequestParam int page, @RequestParam int size) {
        try {
            Page<Products> products = productImplementation.getProducts(page, size);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
