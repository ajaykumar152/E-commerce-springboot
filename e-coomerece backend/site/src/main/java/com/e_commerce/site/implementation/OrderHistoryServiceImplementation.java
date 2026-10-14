package com.e_commerce.site.implementation;

import com.e_commerce.site.DTO.GetOrderHistoryDTO;
import com.e_commerce.site.DTO.OrderHistoryDTO;
import com.e_commerce.site.members.Products;
import com.e_commerce.site.members.OrderHistory;
import com.e_commerce.site.repository.OrderHistoryRepository;
import com.e_commerce.site.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderHistoryServiceImplementation implements OrderHistoryService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override 
    public Page<OrderHistoryDTO> getOrderHistory(GetOrderHistoryDTO getOrderHistoryDTO) {
        
        int page = getOrderHistoryDTO.getPage();
        int size = getOrderHistoryDTO.getSize();
        Long customerUser = getOrderHistoryDTO.getCustomerUser();
        String customerType = getOrderHistoryDTO.getCustomerType();

        Pageable pageable = PageRequest.of(page, size);
        Page<OrderHistory> orderHistory =  orderHistoryRepository.findByCustomerUserAndCustomerType(customerUser, customerType, pageable);

        return orderHistory.map(item -> new OrderHistoryDTO(
            item.getStatus(), item.getCustomerUser(), item.getCustomerType(),
            item.getDate(), item.getProduct()
        ));
    }

    @Override 
    public boolean addCancelledProduct(OrderHistoryDTO orderHistory) {
        OrderHistory orderHistoryNew = new OrderHistory();

        orderHistoryNew.setCustomerType(orderHistory.getCustomerType());
        orderHistoryNew.setCustomerUser(orderHistory.getCustomerUser());
        orderHistoryNew.setDate(java.time.LocalDate.now().toString());
        orderHistoryNew.setProduct(orderHistory.getProduct());
        orderHistoryNew.setStatus(orderHistory.getStatus());

        OrderHistory orderHistorySaved = orderHistoryRepository.save(orderHistoryNew);

        if(orderHistorySaved != null) {
            return true;
        } else {
            return false;
        }
    }
}