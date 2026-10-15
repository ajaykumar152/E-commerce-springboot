package com.e_commerce.site.service;

import com.e_commerce.site.DTO.GetActiveOrdersProductDTO;
import com.e_commerce.site.DTO.OrderedProductDTO;
import com.e_commerce.site.members.OrderDetails;
import com.e_commerce.site.members.OrderedCustomer;
import com.e_commerce.site.members.Products;

import java.util.List;

public interface OrderDetailsService {
    boolean addOrderedProduct(OrderedProductDTO orderedProductDTO, OrderedCustomer orderedCustomer);
    boolean addAllCartProducts(Long cartId, OrderedProductDTO orderedProductDTO,  OrderedCustomer orderedCustomer);
    boolean searchForProduct(OrderedProductDTO orderedProductDTO, OrderedCustomer orderedCustomer);
    List<GetActiveOrdersProductDTO>  getAllActiveOrders(Long customerId, int page);
    boolean cancelOrder(Long orderId);
    List<GetActiveOrdersProductDTO>  getAllInActiveOrders(Long customerId, int page);
}
