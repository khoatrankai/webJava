package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.UserAll.UserAll;

import com.example.demo.entity.UserAll;

@Repository
public interface UserAllReponsitory extends JpaRepository<UserAll, Integer> {
	
}
