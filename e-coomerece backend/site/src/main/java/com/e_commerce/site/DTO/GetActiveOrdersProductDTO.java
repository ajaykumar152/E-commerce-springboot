package com.e_commerce.site.DTO;

import com.e_commerce.site.members.OrderDetails;
import com.e_commerce.site.members.Products;

public interface GetActiveOrdersProductDTO {
    long getId();
    int getQuantity();
    Products getProducts();
    String getDate();
    String getStatus();
}
