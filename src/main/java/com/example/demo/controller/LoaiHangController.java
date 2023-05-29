package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoaiHang;
import com.example.demo.service.LoaiHangService;

@Controller
@RestController
public class LoaiHangController {
	private LoaiHangService loaihangService;

	public LoaiHangController(LoaiHangService loaihangService) {
		super();
		this.loaihangService = loaihangService;
	}
    
	@GetMapping	("/loaihangs")
	public String listLoaiHangs(Model model) {
		model.addAttribute("loaihangs",loaihangService.getLoaiHangs());
		return "loaihangs";
	}
    
}
