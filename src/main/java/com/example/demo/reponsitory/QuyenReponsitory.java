package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.Quyen.Quyen;

import com.example.demo.entity.Quyen;

@Repository
public interface QuyenReponsitory extends JpaRepository<Quyen, Integer> {
	
}
