package com.example.demo.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAll;


@Service
public interface UserAllService {
	List<UserAll> getUserAlls();
	int checkinuser(String tk,String mk);
	UserAll getUserID(int idU);
	void save(UserAll user);
	void deletebyID(int id);
}
