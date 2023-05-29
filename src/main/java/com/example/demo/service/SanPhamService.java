package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.SanPham;


@Service
public interface SanPhamService {
	List<SanPham> getSanPhams();
	List<SanPham> getSpLoaiHangs(int id);
	List<SanPham> getSpThuongHieus(int id);
	SanPham saveSanPham(SanPham sp);
	SanPham getById(int idSP);
	void deletesp(int idSP);
	
}
