package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DatHang;
import com.example.demo.reponsitory.DatHangReponsitory;
import com.example.demo.service.DatHangService;


@Service
public class DatHangServicelmpl implements DatHangService{
	
	private DatHangReponsitory datHangReponsitory;
	
	
	
	public DatHangServicelmpl(DatHangReponsitory datHangReponsitory) {
		super();
		this.datHangReponsitory = datHangReponsitory;
	}



	@Override
	public List<DatHang> getDatHangs(){
		return datHangReponsitory.findAll();
	}



	@Override
	public void save(DatHang dh) {
		// TODO Auto-generated method stub
		datHangReponsitory.save(dh);
	}



	@Override
	public DatHang getByID(int id) {
		// TODO Auto-generated method stub
		return datHangReponsitory.getById(id);
	}



	@Override
	public void delete(int idDH) {
		// TODO Auto-generated method stub
		datHangReponsitory.deleteById(idDH);
	}
}
