package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TinhTrang;
import com.example.demo.reponsitory.TinhTrangReponsitory;
import com.example.demo.service.TinhTrangService;


@Service
public class TinhTrangServicelmpl implements TinhTrangService{
	
	private TinhTrangReponsitory tinhTrangReponsitory;
	
	
	
	public TinhTrangServicelmpl(TinhTrangReponsitory tinhTrangReponsitory) {
		super();
		this.tinhTrangReponsitory = tinhTrangReponsitory;
	}



	@Override
	public List<TinhTrang> getTinhTrangs(){
		return tinhTrangReponsitory.findAll();
	}



	@Override
	public TinhTrang getTT(int id) {
		// TODO Auto-generated method stub
		return tinhTrangReponsitory.getById(id);
	}
}
