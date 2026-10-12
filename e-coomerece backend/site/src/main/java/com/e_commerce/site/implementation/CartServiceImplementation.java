package com.e_commerce.site.implementation;

import com.e_commerce.site.DTO.SendCartItemsDTO;
import com.e_commerce.site.members.Cart;
import com.e_commerce.site.members.CartItems;
import com.e_commerce.site.members.Customer;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.repository.CartRepository;
import com.e_commerce.site.repository.CustomerRepository;
import com.e_commerce.site.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartServiceImplementation implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemsServiceImplementation cartItemsServiceImplementation;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean addProductToCart(String user, String productId) {
        Cart repocart = cartRepository.findByCustomer_CustomerUsername(user);

        try {
            if (repocart == null) {
                Customer customer = customerRepository.findByCustomerUsername(user);
                Cart saveUser = new Cart();
                saveUser.setCustomer(customer);
                Cart newUser = cartRepository.save(saveUser);
                cartItemsServiceImplementation.addProductToCartItems(newUser, productId);
                return true;
            } else {
                cartItemsServiceImplementation.addProductToCartItems(repocart, productId);
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public SendCartItemsDTO getAllCartProducts(String user, int page, int pageSize) {
        Cart userCartId = cartRepository.findByCustomer_CustomerUsername(user);

       if(userCartId == null) {
         return null;
       } else {
           Page<CartItems> cartItems =  cartItemsServiceImplementation.getAllCartItems(userCartId.getId(),  page, pageSize);
           List<Products> products = new ArrayList<>();
           List<Integer> productQuantity = new ArrayList<>();
           double totalPrice = 0.0;

           for(CartItems cartItem : cartItems) {
               products.add(cartItem.getProducts());
               productQuantity.add(cartItem.getProductQuantity());
               totalPrice += (cartItem.getProducts().getPrice() * cartItem.getProductQuantity());
           }

           SendCartItemsDTO response = new SendCartItemsDTO(products, productQuantity, totalPrice);
           return response;
       }
    }

    @Override
    public boolean addPlusOne(String user, String productId) {
        Cart  userCartId = cartRepository.findByCustomer_CustomerUsername(user);
        try {
           cartItemsServiceImplementation.addPlusOne(userCartId, productId);
           return true;
        }  catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean subMinusOne(String user, String productId) {
        Cart  userCartId = cartRepository.findByCustomer_CustomerUsername(user);
        try {
            cartItemsServiceImplementation.subMinusOne(userCartId, productId);
            return true;
        }  catch (Exception ex) {
            return false;
        }
    }
}
