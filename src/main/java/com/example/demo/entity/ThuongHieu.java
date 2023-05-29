package com.example.demo.entity;

import java.util.List;

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
@Table(name = "thuonghieu")
public class ThuongHieu {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTH;
	
	@Column(name = "tenTH",nullable = false)
	private String tenTH;
	
	@OneToMany(mappedBy = "thuonghieu", cascade = CascadeType.ALL)
	private List<SanPham> sanphams;


	
	
	
}
