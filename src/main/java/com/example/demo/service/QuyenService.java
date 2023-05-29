package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quyen;


@Service
public interface QuyenService {
	List<Quyen> getQuyens();
}
