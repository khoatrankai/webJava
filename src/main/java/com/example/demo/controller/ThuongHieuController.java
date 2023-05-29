package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.service.ThuongHieuService;

@Controller
public class ThuongHieuController {
	private ThuongHieuService thuonghieuService;

	public ThuongHieuController(ThuongHieuService thuonghieuService) {
		super();
		this.thuonghieuService = thuonghieuService;
	}
    
//	@GetMapping	("/thuonghieus")
//	public List<ThuongHieu> listThuongHieus() {
//		
//		return thuonghieuService.getThuongHieus();
//	}
	@GetMapping	("/thuonghieus")
	public String listThuongHieus(Model model) {
		
		model.addAttribute("thuonghieus",thuonghieuService.getThuongHieus());
		return "thuonghieu";
	}
    
}
