package com.e_commerce.site.members;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;

import java.util.List;

@Entity
@Table(name = "activeorders")
public class OrderedCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_username")
    private Customer customer;

    @OneToMany(mappedBy = "orderedCustomer")
    @JsonIgnore
    private List<OrderDetails> orderDetails;

    public OrderedCustomer() {
    }

    public OrderedCustomer(Long id, Customer customer, List<OrderDetails> orderDetails) {
        this.id = id;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
