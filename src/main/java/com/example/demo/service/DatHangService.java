package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DatHang;


@Service
public interface DatHangService {
	List<DatHang> getDatHangs();
	void save(DatHang dh);
	DatHang getByID(int id);
	void delete(int idDH);
}
