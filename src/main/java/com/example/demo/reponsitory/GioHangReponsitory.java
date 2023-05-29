package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.GioHang.GioHang;

import com.example.demo.entity.GioHang;

@Repository
public interface GioHangReponsitory extends JpaRepository<GioHang, Integer> {
	
}
