package com.e_commerce.site.controller;

import com.e_commerce.site.DTO.GetActiveOrdersProductDTO;
import com.e_commerce.site.DTO.OrderedProductDTO;
import com.e_commerce.site.implementation.OrderedCustomerServiceImplementation;
import com.e_commerce.site.members.OrderDetails;
import com.e_commerce.site.members.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "https://reimagined-succotash-pjgw77jjw69j29747-5173.app.github.dev")
public class OrderDetailsController {

    @Autowired
    private OrderedCustomerServiceImplementation orderedCustomerServiceImplementation;

    @PostMapping("/{username}")
    public ResponseEntity<Boolean> addOrderDetails(@PathVariable String username, @RequestBody OrderedProductDTO orderedProductDTO) {
        try {
            boolean added = orderedCustomerServiceImplementation.findUser(orderedProductDTO,username);
            return new ResponseEntity<>(added, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/products/{username}")
    public ResponseEntity<Boolean> addCartProducts(@PathVariable String username, @RequestBody OrderedProductDTO orderedProductDTO) {
        try {
            boolean added = orderedCustomerServiceImplementation.findCartUser(username, orderedProductDTO);
            return new ResponseEntity<>(added, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<GetActiveOrdersProductDTO>>  getActiveOrdersProducts(@RequestParam String username) {
        try {
            List<GetActiveOrdersProductDTO> getActiveOrdersProductDTOS = orderedCustomerServiceImplementation.getUser(username);
            return new ResponseEntity<>(getActiveOrdersProductDTOS, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
