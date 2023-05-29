package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TinhTrang;


@Service
public interface TinhTrangService {
	List<TinhTrang> getTinhTrangs();
	TinhTrang getTT(int id);
}
