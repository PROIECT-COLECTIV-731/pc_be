package com.example.project.controller;

import com.example.project.dto.AdminDto;
import com.example.project.entity.AdminEntity;
import com.example.project.service.AdminService;
import com.example.project.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/get-all")
    public ResponseEntity<List<AdminDto>> getAllAdmin() {
        return ResponseEntity.ok(adminService.findAll());
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<AdminDto> findAdminByEmailAndPassword(@PathVariable String email, String password) {
        return ResponseEntity.ok(this.adminService.findByEmailAndPassword(email, password));
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody String email, String password)
    {return ResponseEntity.ok(adminService.login(email, password));}

    @PostMapping(value = "/save")
    public AdminEntity saveAdmin(@RequestBody AdminEntity adminEntity) {
        if(adminService.email_validator(adminEntity) && adminService.name_validator(adminEntity) && adminService.password_validator(adminEntity)){
            AdminEntity admin = new AdminEntity();
            admin.setEmail(adminEntity.getEmail());
            admin.setPassword(adminEntity.getPassword());
            admin.setFirstName(adminEntity.getFirstName());
            admin.setLastName(adminEntity.getLastName());
            admin.setId(adminEntity.getId());
            return adminService.saveAdmin(admin);
        }
        return null;
    }
}
