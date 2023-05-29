package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ThuongHieu;


@Service
public interface ThuongHieuService {
	List<ThuongHieu> getThuongHieus();
}
