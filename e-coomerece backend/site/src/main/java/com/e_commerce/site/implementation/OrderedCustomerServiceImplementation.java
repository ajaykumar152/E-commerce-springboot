package com.e_commerce.site.implementation;

import com.e_commerce.site.DTO.GetActiveOrdersProductDTO;
import com.e_commerce.site.DTO.OrderedProductDTO;
import com.e_commerce.site.members.*;
import com.e_commerce.site.repository.CartRepository;
import com.e_commerce.site.repository.CustomerRepository;
import com.e_commerce.site.repository.OrderedCustomerRepository;
import com.e_commerce.site.service.OrderedCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderedCustomerServiceImplementation implements OrderedCustomerService {

    @Autowired
    private OrderedCustomerRepository orderedCustomerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderDetailsServiceImplementation orderDetailsServiceImplementation;

    @Autowired
    private CartRepository cartRepository;

    public boolean findUser(OrderedProductDTO orderedProductDTO, String username) {
        OrderedCustomer orderedCustomer = orderedCustomerRepository.findByCustomer_CustomerUsername(username);

        if (orderedCustomer == null) {
            Customer customer = customerRepository.findByCustomerUsername(username);
            OrderedCustomer orderedCustomer1 = new OrderedCustomer();
            orderedCustomer1.setCustomer(customer);
            OrderedCustomer order = orderedCustomerRepository.save(orderedCustomer1);
            return orderDetailsServiceImplementation.addOrderedProduct(orderedProductDTO, order);
        } else {
            return orderDetailsServiceImplementation.searchForProduct(orderedProductDTO, orderedCustomer);
        }
    }

    @Override
    public boolean findCartUser(String username, OrderedProductDTO orderedProductDTO) {
        Cart cart = cartRepository.findByCustomer_CustomerUsername(username);
        OrderedCustomer orderedCustomer = orderedCustomerRepository.findByCustomer_CustomerUsername(username);

        if (orderedCustomer == null) {
            Customer customer = customerRepository.findByCustomerUsername(username);
            OrderedCustomer orderedCustomer1 = new OrderedCustomer();
            orderedCustomer1.setCustomer(customer);
            OrderedCustomer orderCustomer = orderedCustomerRepository.save(orderedCustomer1);
            return orderDetailsServiceImplementation.addAllCartProducts(cart.getId(), orderedProductDTO, orderCustomer);
        } else {
            return orderDetailsServiceImplementation.addAllCartProducts(cart.getId(), orderedProductDTO, orderedCustomer);
        }
    }

    public List<GetActiveOrdersProductDTO> getUser(String username, int page){
        OrderedCustomer orderedCustomer = orderedCustomerRepository.findByCustomer_CustomerUsername(username);
        if (orderedCustomer == null) {
            return null;
        } else {
            return orderDetailsServiceImplementation.getAllActiveOrders(orderedCustomer.getId(), page);
        }
    }

    public List<GetActiveOrdersProductDTO> findUser(String username, int page){
        OrderedCustomer orderedCustomer = orderedCustomerRepository.findByCustomer_CustomerUsername(username);
        if (orderedCustomer == null) {
            return null;
        } else {
            return orderDetailsServiceImplementation.getAllInActiveOrders(orderedCustomer.getId(), page);
        }
    }
}
