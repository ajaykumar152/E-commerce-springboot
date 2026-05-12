package com.e_commerce.site.members;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    private String adminUsername;

    private String email;
    private Long phone;
    private String password;
    private String role = "admin";

    @OneToOne(mappedBy = "admin")
    private Cart cart;

    public Admin(String adminUsername, String email, Long phone, String password) {
        this.adminUsername = adminUsername;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Admin() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
