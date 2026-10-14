package com.e_commerce.site.service;

import com.e_commerce.site.DTO.GetOrderHistoryDTO;
import com.e_commerce.site.DTO.OrderHistoryDTO;
import org.springframework.data.domain.Page;


public interface OrderHistoryService {
    Page<OrderHistoryDTO> getOrderHistory(GetOrderHistoryDTO orderHistory);
    boolean addCancelledProduct(OrderHistoryDTO orderHistoryDTO);
}