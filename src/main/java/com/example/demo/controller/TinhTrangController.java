package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TinhTrang;
import com.example.demo.service.TinhTrangService;

@Controller
public class TinhTrangController {
	private TinhTrangService tinhtrangService;

	public TinhTrangController(TinhTrangService tinhtrangService) {
		super();
		this.tinhtrangService = tinhtrangService;
	}
    
	@GetMapping	("/tinhtrangs")
	public String listTinhTrangs(Model model) {
		model.addAttribute("tinhtrangs",tinhtrangService.getTinhTrangs());
		return "tinhtrangs";
	}
    
}
