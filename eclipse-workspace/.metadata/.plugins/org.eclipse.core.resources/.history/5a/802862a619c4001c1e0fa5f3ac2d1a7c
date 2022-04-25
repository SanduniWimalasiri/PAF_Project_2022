package com.example.PBGS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.PBGS.model.Admin;
import com.example.PBGS.repository.AdminRepository;

@RestControllerAdvice
@RequestMapping("/api/v1/")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	//Get all Admins
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
}
