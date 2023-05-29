package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserAll;
import com.example.demo.service.UserAllService;

@Controller
public class UserAllController {
	private UserAllService userallService;

	public UserAllController(UserAllService userallService) {
		super();
		this.userallService = userallService;
	}
    
	
    
}
