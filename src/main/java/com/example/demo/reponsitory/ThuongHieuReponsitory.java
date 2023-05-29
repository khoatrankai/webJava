package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.ThuongHieu.ThuongHieu;

import com.example.demo.entity.ThuongHieu;

@Repository
public interface ThuongHieuReponsitory extends JpaRepository<ThuongHieu, Integer> {
	
}
