package com.example.project.service;

import com.example.project.dto.AdminDto;
import com.example.project.entity.AdminEntity;
import org.mapstruct.control.MappingControl;

import java.util.List;


public interface AdminService {
    List<AdminDto> findAll();

    AdminDto findByEmailAndPassword(String email, String password);

    String login(String email, String password);

    boolean email_validator(AdminEntity adminEntity);
    boolean name_validator(AdminEntity adminEntity);
    boolean password_validator(AdminEntity adminEntity);
    AdminEntity saveAdmin(AdminEntity adminEntity);

}
