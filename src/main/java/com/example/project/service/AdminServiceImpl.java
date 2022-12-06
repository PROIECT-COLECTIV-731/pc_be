package com.example.project.service;

import com.example.project.dto.AdminDto;
import com.example.project.entity.AdminEntity;
import com.example.project.mapper.AdminMapper;
import com.example.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminDto> findAll() {
        return adminMapper.entitiesToDtos(this.adminRepository.findAll());
    }

    @Override
    public AdminDto findByEmailAndPassword(String email, String password) {
        return adminMapper.entityToDto(this.adminRepository.findByEmailAndPassword(email, password));
    }
    @Override
    public String login(String email, String password){
        try {
            AdminDto admin = findByEmailAndPassword(email, password);
            if (admin != null && email.contains("@ubbcluj.ro")) {
                return "adminAccepted";
            }
            return null;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean email_validator(AdminEntity adminEntity){
        return adminEntity.getEmail().endsWith("@stud.ubbcluj.ro");
    }
    public boolean name_validator(AdminEntity adminEntity){
        return adminEntity.getFirstName().length() > 0 && adminEntity.getLastName().length() > 0;
    }
    public boolean password_validator(AdminEntity adminEntity){
        return adminEntity.getPassword().length()>0;
    }
    public AdminEntity saveAdmin(AdminEntity adminEntity){
        return adminRepository.save(adminEntity);
    }

}
