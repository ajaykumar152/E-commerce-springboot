package com.e_commerce.site.implementation;

import com.e_commerce.site.members.Cart;
import com.e_commerce.site.members.CartItems;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.repository.CartItemsRepository;
import com.e_commerce.site.repository.ProductsRepository;
import com.e_commerce.site.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartItemsServiceImplementation implements CartItemsService {

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public boolean addProductToCartItems(Cart cart, String productId) {
        CartItems cartItem = cartItemsRepository.findByCartIdAndProductsId(cart.getId(), productId);

        try {
            if (cartItem == null) {
                Products product = productsRepository.findProductsById(productId);
                CartItems newCartItem = new CartItems();
                newCartItem.setProducts(product);
                newCartItem.setProductQuantity(1);
                newCartItem.setCart(cart);
                cartItemsRepository.save(newCartItem);
                return true;
            } else {
                int quantity = cartItem.getProductQuantity() + 1;
                cartItem.setProductQuantity(quantity);
                cartItemsRepository.save(cartItem);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public Page<CartItems> getAllCartItems(Long cartId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return cartItemsRepository.findAllByCart_Id(cartId, pageable);
    }

    @Override
    public boolean addPlusOne(Cart cart, String productId) {
        CartItems cartItem = cartItemsRepository.findByCartIdAndProductsId(cart.getId(), productId);

        try {
            int qunatity = cartItem.getProductQuantity() + 1;
            cartItem.setProductQuantity(qunatity);
            cartItemsRepository.save(cartItem);
            return true;
        }  catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean subMinusOne(Cart cart, String productId) {
        CartItems cartItem = cartItemsRepository.findByCartIdAndProductsId(cart.getId(), productId);
        try {
            int qunatity = cartItem.getProductQuantity();

            if(qunatity > 1) {
                cartItem.setProductQuantity(qunatity - 1);
                cartItemsRepository.save(cartItem);
                return true;
            } else {
                cartItemsRepository.deleteById(cartItem.getId());
                return true;
            }
        }  catch (Exception e) {
            return false;
        }
    }

}
