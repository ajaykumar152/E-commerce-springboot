package com.e_commerce.site.controller;

import com.e_commerce.site.DTO.GetOrderHistoryDTO;
import com.e_commerce.site.DTO.OrderHistoryDTO;
import com.e_commerce.site.implementation.OrderHistoryServiceImplementation;
import com.e_commerce.site.members.OrderHistory;
import com.e_commerce.site.members.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/orderHistory")
@CrossOrigin(origins="${app.front-end.url}")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryServiceImplementation orderHistoryServiceImplementation;


    @GetMapping
    public ResponseEntity<Page<OrderHistoryDTO>> getOrderHistory(@RequestBody GetOrderHistoryDTO getOrderHistoryDTO) {
        
        Page<OrderHistoryDTO> orderHistory = orderHistoryServiceImplementation.getOrderHistory(getOrderHistoryDTO);
        return new ResponseEntity<>(orderHistory, HttpStatus.OK);
       
    }

    @PostMapping
    public ResponseEntity<Boolean> addCancelledProduct(@RequestBody OrderHistoryDTO orderHistory) {
        try {
            boolean cancelled = orderHistoryServiceImplementation.addCancelledProduct(orderHistory);
            if(cancelled) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}