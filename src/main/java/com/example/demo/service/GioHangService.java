package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GioHang;


@Service
public interface GioHangService {
	List<GioHang> getGioHangs();
	List<GioHang> getByIDGH(int idU);
	void cartadd(int idGH);
	void cartminus(int idGH);
	void cartdelete(int idGH);
	int totalPrice(int idU);
	void saveGH(GioHang gh);
	void deleteGHID(int id);
}
