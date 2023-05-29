package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoaiHang;


@Service
public interface LoaiHangService {
	List<LoaiHang> getLoaiHangs();
}
