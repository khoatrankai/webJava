package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoaiHang;
import com.example.demo.reponsitory.LoaiHangReponsitory;
import com.example.demo.service.LoaiHangService;


@Service
public class LoaiHangServicelmpl implements LoaiHangService{
	
	private LoaiHangReponsitory loaiHangReponsitory;
	
	
	
	public LoaiHangServicelmpl(LoaiHangReponsitory loaiHangReponsitory) {
		super();
		this.loaiHangReponsitory = loaiHangReponsitory;
	}



	@Override
	public List<LoaiHang> getLoaiHangs(){
		return loaiHangReponsitory.findAll();
	}
}
