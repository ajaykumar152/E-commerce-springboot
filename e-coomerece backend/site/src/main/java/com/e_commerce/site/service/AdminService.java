package com.e_commerce.site.service;

import com.e_commerce.site.members.Admin;

public interface AdminService {

    boolean addAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
    boolean deleteAdmin(Admin admin);
    boolean validateAdmin(Admin admin);
}
