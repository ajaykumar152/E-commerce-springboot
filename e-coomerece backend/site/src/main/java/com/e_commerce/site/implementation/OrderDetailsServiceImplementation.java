package com.e_commerce.site.implementation;

import com.e_commerce.site.DTO.GetActiveOrdersProductDTO;
import com.e_commerce.site.DTO.OrderedProductDTO;
import com.e_commerce.site.members.CartItems;
import com.e_commerce.site.members.OrderDetails;
import com.e_commerce.site.members.OrderedCustomer;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.repository.CartItemsRepository;
import com.e_commerce.site.repository.OrderDetailsRepository;
import com.e_commerce.site.repository.ProductsRepository;
import com.e_commerce.site.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OrderDetailsServiceImplementation implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    public boolean addOrderedProduct(OrderedProductDTO orderedProductDTO, OrderedCustomer orderedCustomer) {
        try {
            OrderDetails orderDetails1 = new OrderDetails();
            orderDetails1.setCustomername(orderedProductDTO.getCustomername());
            orderDetails1.setPhone(orderedProductDTO.getPhone());
            orderDetails1.setTown(orderedProductDTO.getTown());
            orderDetails1.setCity(orderedProductDTO.getCity());
            orderDetails1.setState(orderedProductDTO.getState());
            orderDetails1.setPincode(orderedProductDTO.getPincode());
            orderDetails1.setQuantity(orderedProductDTO.getQuantity());
            orderDetails1.setOrderedCustomer(orderedCustomer);
            orderDetails1.setDate(LocalDate.now().plusDays(3).toString());
            Products product = productsRepository.findById(orderedProductDTO.getProductId()).get();
            orderDetails1.setProducts(product);
            orderDetailsRepository.save(orderDetails1);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAllCartProducts(Long cartId, OrderedProductDTO orderedProductDTO, OrderedCustomer orderedCustomer) {
        int start = 0;
        int end = 10;
        Pageable pageable = PageRequest.of(start, end);
        List<CartItems> cartItemsList = cartItemsRepository.findAllByCart_Id(cartId, pageable).getContent();
        for (CartItems cartItems : cartItemsList) {
           orderedProductDTO.setQuantity(cartItems.getProductQuantity());
           orderedProductDTO.setProductId(cartItems.getProducts().getId());
           searchForProduct(orderedProductDTO, orderedCustomer);
        }
        return true;
    }

    @Override
    public boolean searchForProduct(OrderedProductDTO orderedProductDTO, OrderedCustomer orderedCustomer) {
        List<OrderDetails> orderDetails = orderDetailsRepository.findAllByOrderedCustomerIdAndProductsId(orderedCustomer.getId(), orderedProductDTO.getProductId());

        for(OrderDetails orderDetail : orderDetails) {
            if(orderDetail.getDate().equals(LocalDate.now().plusDays(3).toString()) &&
            orderDetail.getTown().equals(orderedProductDTO.getTown()) &&
            orderDetail.getCity().equals(orderedProductDTO.getCity()) &&
            orderDetail.getState().equals(orderedProductDTO.getState()) &&
            orderDetail.getPincode().equals(orderedProductDTO.getPincode()) &&
            orderDetail.getPhone().equals(orderedProductDTO.getPhone())) {
                orderDetail.setQuantity(orderDetail.getQuantity() + orderedProductDTO.getQuantity());
                orderDetailsRepository.save(orderDetail);
                return true;
            }
        }
        return addOrderedProduct(orderedProductDTO, orderedCustomer);
    }

    @Override
    public List<GetActiveOrdersProductDTO> getAllActiveOrders(Long customerId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        List<GetActiveOrdersProductDTO> getActiveOrdersProductDTO = orderDetailsRepository.findAllByOrderedCustomerIdAndStatusOrStatus(customerId, "Preparing", "Shipped", pageable);
        return  getActiveOrdersProductDTO;
    }

    @Override 
    public boolean cancelOrder(Long orderId) {
        OrderDetails orderDetails = orderDetailsRepository.findById(orderId)
                                    .orElseThrow(() -> new RuntimeException("Order not found"));
        orderDetails.setStatus("Cancelled");
        orderDetailsRepository.save(orderDetails);
        return true;
    }

    @Override 
    public List<GetActiveOrdersProductDTO> getAllInActiveOrders(Long customerId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        List<GetActiveOrdersProductDTO> getActiveOrdersProductDTO = orderDetailsRepository.findAllByOrderedCustomerIdAndStatusOrStatus(customerId, "Cancelled", "Delivered", pageable);
        return  getActiveOrdersProductDTO;
    }
}