package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quyen")
public class Quyen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQ;
	
	@Column(name = "tenQ",nullable = false)
	private String tenQ;
	
	@OneToMany(mappedBy = "quyen", cascade = CascadeType.ALL)
	private List<UserAll> users;
	
	
	
}
