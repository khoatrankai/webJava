package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAll;
import com.example.demo.reponsitory.UserAllReponsitory;
import com.example.demo.service.UserAllService;


@Service
public class UserAllServicelmpl implements UserAllService{
	
	private UserAllReponsitory userAllReponsitory;
	
	
	
	public UserAllServicelmpl(UserAllReponsitory userAllReponsitory) {
		super();
		this.userAllReponsitory = userAllReponsitory;
	}



	@Override
	public List<UserAll> getUserAlls(){
		return userAllReponsitory.findAll();
	}



	@Override
	public int checkinuser(String tk, String mk) {
		// TODO Auto-generated method stub
		int idU = 0;
		List<UserAll> user = userAllReponsitory.findAll();
		for(UserAll a : user) {
			if(a.getTaikhoan().equals(tk) && a.getMatkhau().equals(mk)) {
				idU = a.getIdUser();
			}
		}
		
		return idU;
	}



	@Override
	public UserAll getUserID(int idU) {
		// TODO Auto-generated method stub
		
		return userAllReponsitory.getById(idU);
	}



	@Override
	public void save(UserAll user) {
		// TODO Auto-generated method stub
		userAllReponsitory.save(user);
	}



	@Override
	public void deletebyID(int id) {
		// TODO Auto-generated method stub
		userAllReponsitory.deleteById(id);
	}
}
