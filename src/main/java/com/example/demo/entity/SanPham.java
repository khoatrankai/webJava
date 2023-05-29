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
@Table(name = "sanpham")
public class SanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSP;
	
	@Column(name = "tenSP",nullable = false)
	private String tenSP;
	
	@Column(name = "motaSP")
	private String motaSP;
	
	@Column(name = "giaSP")
	private int giaSP;
	
	@Column(name = "imgSP",nullable = false)
	private String imgSP;
	
	@ManyToOne
	@JoinColumn(name="loaihang")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private LoaiHang loaihang;
	
	@ManyToOne
	@JoinColumn(name="thuonghieu")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private ThuongHieu thuonghieu;
	
	@OneToMany(mappedBy = "sanphams", cascade = CascadeType.ALL)
	private List<DatHang> dathangs;
	
	@OneToMany(mappedBy = "sanphams", cascade = CascadeType.ALL)
	private List<GioHang> giohangs;
	
	
}
