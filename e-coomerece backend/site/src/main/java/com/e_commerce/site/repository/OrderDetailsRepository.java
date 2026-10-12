package com.e_commerce.site.repository;

import com.e_commerce.site.DTO.GetActiveOrdersProductDTO;
import com.e_commerce.site.members.OrderDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findAllByOrderedCustomerIdAndProductsId(Long customer_id, String product_id);
    List<GetActiveOrdersProductDTO> findAllByOrderedCustomerIdAndStatusOrStatus(Long customer_id, String preparing, String Shipped, Pageable pageable);
}
