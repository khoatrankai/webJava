package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Quyen;
import com.example.demo.reponsitory.QuyenReponsitory;
import com.example.demo.service.QuyenService;


@Service
public class QuyenServicelmpl implements QuyenService{
	
	private QuyenReponsitory quyenReponsitory;
	
	
	
	public QuyenServicelmpl(QuyenReponsitory quyenReponsitory) {
		super();
		this.quyenReponsitory = quyenReponsitory;
	}



	@Override
	public List<Quyen> getQuyens(){
		return quyenReponsitory.findAll();
	}
}
