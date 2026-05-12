package com.e_commerce.site.repository;

import com.e_commerce.site.members.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    Admin findByAdminUsername(String username);
}
