package com.e_commerce.site.controller;

import com.e_commerce.site.implementation.AdminServiceImplementation;
import com.e_commerce.site.members.Admin;
import com.e_commerce.site.members.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "${app.front-end.url}")
public class AdminController {

    @Autowired
    private AdminServiceImplementation adminServiceImplementation;

    @PostMapping
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
        boolean result = adminServiceImplementation.addAdmin(admin);

        if (result) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
        boolean result = adminServiceImplementation.updateAdmin(admin);

        if (result) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else
            return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAdmin(@RequestBody Admin admin) {
        boolean result = adminServiceImplementation.deleteAdmin(admin);

        if (result) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        }  else {
            return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<String> getCustomer(@RequestBody Admin admin) {
        boolean result =  adminServiceImplementation.validateAdmin(admin);

        if (result) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        }  else {
            return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
        }
    }
}
