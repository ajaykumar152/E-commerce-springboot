package com.e_commerce.site.implementation;

import com.e_commerce.site.members.Admin;
import com.e_commerce.site.repository.AdminRepository;
import com.e_commerce.site.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean addAdmin(Admin admin) {
        Admin isAdmin = adminRepository.findByAdminUsername(admin.getAdminUsername());
        if (isAdmin == null) {
            adminRepository.save(admin);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        Admin isAdmin = adminRepository.findByAdminUsername(admin.getAdminUsername());

        if(isAdmin != null){
            isAdmin.setEmail(admin.getEmail());
            isAdmin.setPhone(admin.getPhone());
            isAdmin.setAdminUsername(admin.getAdminUsername());
            adminRepository.save(isAdmin);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAdmin(Admin admin) {
        try {
            adminRepository.delete(admin);
            return true;
        }  catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean validateAdmin(Admin admin) {
        Admin isAdmin = adminRepository.findByAdminUsername(admin.getAdminUsername());

        if(isAdmin != null && isAdmin.getPassword().equals(admin.getPassword())){
            return true;
        } else {
            return false;
        }
    }
}
