package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.SignConf;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.LoaiHang;
import com.example.demo.entity.SanPham;
import com.example.demo.reponsitory.LoaiHangReponsitory;
import com.example.demo.reponsitory.SanPhamReponsitory;
import com.example.demo.service.SanPhamService;


@Service
public class SanPhamServicelmpl implements SanPhamService{
	
	private SanPhamReponsitory sanPhamReponsitory;
	
	@Autowired
	private LoaiHangReponsitory lhReponsitory;
	
	
	
	public SanPhamServicelmpl(SanPhamReponsitory sanPhamReponsitory) {
		super();
		this.sanPhamReponsitory = sanPhamReponsitory;
	}



	@Override
	public List<SanPham> getSanPhams(){
		return sanPhamReponsitory.findAll();
	}



	@Override
	public List<SanPham> getSpLoaiHangs(int id) {
		List<SanPham> a = new ArrayList<SanPham>();
		for(SanPham b : sanPhamReponsitory.findAll())
		{
			if(b.getLoaihang().getIdLH() == id)
			{
				a.add(b);
			}
		}
		return a;
		
	}
	
	@Override
	public List<SanPham> getSpThuongHieus(int id) {
		List<SanPham> a = new ArrayList<SanPham>();
		for(SanPham b : sanPhamReponsitory.findAll())
		{
			if(b.getThuonghieu().getIdTH() == id)
			{
				a.add(b);
			}
		}
		return a;
		
	}



	@Override
	public SanPham saveSanPham(SanPham sp) {
		// TODO Auto-generated method stub
		return sanPhamReponsitory.save(sp);
	}



	@Override
	public SanPham getById(int idSP) {
		// TODO Auto-generated method stub
		return sanPhamReponsitory.getById(idSP);
	}



	@Override
	public void deletesp(int idSP) {
		// TODO Auto-generated method stub
		sanPhamReponsitory.deleteById(idSP);
	}



	
}
