package com.e_commerce.site.service;

import com.e_commerce.site.DTO.GetActiveOrdersProductDTO;
import com.e_commerce.site.DTO.OrderedProductDTO;
import com.e_commerce.site.members.OrderDetails;
import com.e_commerce.site.members.Products;

import java.util.List;

public interface OrderedCustomerService {
    boolean findUser(OrderedProductDTO orderedProductDTO, String username);
    boolean findCartUser(String username, OrderedProductDTO orderedProductDTO);
    List<GetActiveOrdersProductDTO> getUser(String username);
}
