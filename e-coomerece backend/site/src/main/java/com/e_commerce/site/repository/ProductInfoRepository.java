package com.e_commerce.site.repository;

import com.e_commerce.site.members.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,Long> {

    ProductInfo findByProductId(String productId);

}
