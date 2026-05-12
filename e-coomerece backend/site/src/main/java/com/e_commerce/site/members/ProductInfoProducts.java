package com.e_commerce.site.members;

import java.util.List;

public class ProductInfoProducts {
    private ProductInfo productInfo;
    private List<Products> products;

    public ProductInfoProducts(ProductInfo productInfo, List<Products> products) {
        this.productInfo = productInfo;
        this.products = products;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
