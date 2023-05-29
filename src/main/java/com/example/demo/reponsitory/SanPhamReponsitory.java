package com.example.demo.reponsitory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import com.example.demo.SanPham.SanPham;

import com.example.demo.entity.LoaiHang;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.ThuongHieu;

@Repository
public interface SanPhamReponsitory extends JpaRepository<SanPham, Integer> {
	

	
}
