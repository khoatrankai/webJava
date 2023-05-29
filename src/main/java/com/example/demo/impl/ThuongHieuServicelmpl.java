package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.reponsitory.ThuongHieuReponsitory;
import com.example.demo.service.ThuongHieuService;


@Service
public class ThuongHieuServicelmpl implements ThuongHieuService{
	
	private ThuongHieuReponsitory thuongHieuReponsitory;
	
	
	
	public ThuongHieuServicelmpl(ThuongHieuReponsitory thuongHieuReponsitory) {
		super();
		this.thuongHieuReponsitory = thuongHieuReponsitory;
	}



	@Override
	public List<ThuongHieu> getThuongHieus(){
		return thuongHieuReponsitory.findAll();
	}
}
