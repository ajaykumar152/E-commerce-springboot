package com.e_commerce.site.controller;

import com.e_commerce.site.DTO.SendCartItemsDTO;
import com.e_commerce.site.implementation.CartServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "https://reimagined-succotash-pjgw77jjw69j29747-5173.app.github.dev")
public class CartController {

    @Autowired
    private CartServiceImplementation cartServiceImplementation;

    @PostMapping
    public ResponseEntity<Boolean> addToCart(@RequestParam String user, @RequestParam String productId) {

        try {
            cartServiceImplementation.addProductToCart(user, productId);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/products")
    public ResponseEntity<SendCartItemsDTO> getCartproducs(@RequestParam String user, @RequestParam int page, @RequestParam int pageSize) {
        try {
            SendCartItemsDTO response = cartServiceImplementation.getAllCartProducts(user, page, pageSize);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/add")
    public ResponseEntity<Boolean> addPlusOne(@RequestParam String user, @RequestParam String productId) {
        try {
            cartServiceImplementation.addPlusOne(user, productId);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/sub")
    public ResponseEntity<Boolean> minuslusOne(@RequestParam String user, @RequestParam String productId) {
        try {
            cartServiceImplementation.subMinusOne(user, productId);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}

