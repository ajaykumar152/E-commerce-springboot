package com.e_commerce.site.DTO;

public class GetOrderHistoryDTO {
    private int page;
    private int size;
    private Long customerUser;
    private String customerType;

    public GetOrderHistoryDTO(int page, int size, Long customerUser, String customerType) {
        this.page = page;
        this.size = size;
        this.customerUser = customerUser;
        this.customerType = customerType;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCustomerUser(Long customerUser) {
        this.customerUser = customerUser;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public Long getCustomerUser() {
        return customerUser;
    }

    public String getCustomerType() {
        return customerType;
    }

}