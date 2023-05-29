package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GioHang;
import com.example.demo.service.GioHangService;

@Controller
public class GioHangController {
	private GioHangService giohangService;
	int idU = 2;

	public GioHangController(GioHangService giohangService) {
		super();
		this.giohangService = giohangService;
	}
    
	@GetMapping	("/giohangs")
	public String listGioHangs(Model model) {
		model.addAttribute("giohangs",giohangService.getGioHangs());
		return "giohangs";
	}
	
//	@GetMapping("/")
//	public String listGHindex(Model model) {
//		model.addAttribute("giohangs",giohangService.getByIDGH(idU));
//
//		return "index";
//	}
    
}
