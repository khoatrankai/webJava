package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.loaihang.LoaiHang;

import com.example.demo.entity.DatHang;

@Repository
public interface DatHangReponsitory extends JpaRepository<DatHang, Integer> {
	
}
