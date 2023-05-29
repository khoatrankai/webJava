package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.GioHang;
import com.example.demo.reponsitory.GioHangReponsitory;
import com.example.demo.service.GioHangService;


@Service
public class GioHangServicelmpl implements GioHangService{
	
	private GioHangReponsitory gioHangReponsitory;
	
	
	
	public GioHangServicelmpl(GioHangReponsitory gioHangReponsitory) {
		super();
		this.gioHangReponsitory = gioHangReponsitory;
	}



	@Override
	public List<GioHang> getGioHangs(){
		return gioHangReponsitory.findAll();
	}



	@Override
	public List<GioHang> getByIDGH(int idU) {
		List<GioHang> allgh = gioHangReponsitory.findAll();
		List<GioHang> GHid = new ArrayList<>();
		for(GioHang a : allgh) {
			if(idU == a.getUsers().getIdUser()) {
				GHid.add(a);
				
			}
		}
		return GHid;
	}



	@Override
	public void cartadd(int idGH) {
		// TODO Auto-generated method stub
		GioHang gh = gioHangReponsitory.getById(idGH);
		gh.setIdGH(idGH);
		gh.setSoLuong(gh.getSoLuong()+1);
		gioHangReponsitory.save(gh);
	}



	@Override
	public void cartminus(int idGH) {
		// TODO Auto-generated method stub
		GioHang gh = gioHangReponsitory.getById(idGH);
		gh.setIdGH(idGH);
		gh.setSoLuong(gh.getSoLuong()-1);
		gioHangReponsitory.save(gh);
	}



	@Override
	public void cartdelete(int idGH) {
		// TODO Auto-generated method stub
		gioHangReponsitory.deleteById(idGH);
	}



	@Override
	public int totalPrice(int idU) {
		// TODO Auto-generated method stub
		int total =0;
		for(GioHang a : gioHangReponsitory.findAll()) {
			if(a.getUsers().getIdUser() == idU) {
				total = total + (a.getSoLuong() * a.getSanphams().getGiaSP());
			}
		}
		return total;
	}



	@Override
	public void saveGH(GioHang gh) {
		// TODO Auto-generated method stub
		gioHangReponsitory.save(gh);
	}



	@Override
	public void deleteGHID(int id) {
		// TODO Auto-generated method stub
		for(GioHang a : gioHangReponsitory.findAll()) {
			if(a.getUsers().getIdUser() == id) {
				gioHangReponsitory.deleteById(a.getIdGH());
			}
		}
	}
}
