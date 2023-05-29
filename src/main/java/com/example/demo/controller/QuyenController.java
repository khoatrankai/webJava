package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Quyen;
import com.example.demo.service.QuyenService;

@Controller
public class QuyenController {
	private QuyenService quyenService;

	public QuyenController(QuyenService quyenService) {
		super();
		this.quyenService = quyenService;
	}
    
	@GetMapping	("/quyens")
	public String listQuyens(Model model) {
		model.addAttribute("quyens",quyenService.getQuyens());
		return "quyens";
	}
    
}
