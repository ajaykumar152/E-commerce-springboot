package com.e_commerce.site.DTO;

import org.springframework.web.multipart.MultipartFile;


public class GetNewProductDTO {
    private String productName;
    private Double price;
    private String productType;
    private String productDescription;
    private MultipartFile productImage;

    public GetNewProductDTO(String productName, Double price, String productType, String productDescription, MultipartFile productImage) {
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}   