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
@Table(name = "tinhtrang")
public class TinhTrang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTT;
	
	@Column(name = "loaiTT",nullable = false)
	private String loaiTT;
	
	@OneToMany(mappedBy = "tinhtrangs", cascade = CascadeType.ALL)
	private List<DatHang> dathangs;
	
	
}
