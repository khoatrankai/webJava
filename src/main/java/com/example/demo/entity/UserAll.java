package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userall")
public class UserAll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(name = "taikhoan",nullable = false)
	private String taikhoan;
	
	@Column(name = "matkhau",nullable = false)
	private String matkhau;
	
	@Column(name = "tenUser")
	private String tenUser;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "email")
	private String email;
	
	
	@ManyToOne
	@JoinColumn(name="idQ")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Quyen quyen;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<DatHang> dathangs;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<GioHang> giohangs;
	
	
}
