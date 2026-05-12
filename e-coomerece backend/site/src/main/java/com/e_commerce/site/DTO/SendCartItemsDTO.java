package com.e_commerce.site.DTO;

import com.e_commerce.site.members.Products;

import java.util.List;

public class SendCartItemsDTO {

        private List<Products> products;
        private List<Integer> quantity;
        private double totalCartPrice;

        public SendCartItemsDTO(List<Products> products, List<Integer> quantity, double totalCartPrice) {
            this.products = products;
            this.quantity = quantity;
            this.totalCartPrice = totalCartPrice;
        }

        public List<Products> getProducts() {
            return products;
        }

        public void setProducts(List<Products> products) {
            this.products = products;
        }

        public List<Integer> getQuantity() {
            return quantity;
        }

        public void setQuantity(List<Integer> quantity) {
            this.quantity = quantity;
        }

        public double getTotalCartPrice() {
            return totalCartPrice;
        }

        public void setTotalCartPrice(double totalCartPrice) {
            this.totalCartPrice = totalCartPrice;
        }
}

