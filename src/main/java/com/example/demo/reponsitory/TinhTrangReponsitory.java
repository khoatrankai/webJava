package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.TinhTrang.TinhTrang;

import com.example.demo.entity.TinhTrang;

@Repository
public interface TinhTrangReponsitory extends JpaRepository<TinhTrang, Integer> {
	
}
