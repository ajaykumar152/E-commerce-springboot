package com.e_commerce.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.e_commerce.site.members.OrderHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    Page<OrderHistory> findByCustomerUserAndCustomerType(Long customerUser, String customerType, Pageable pageable);
}