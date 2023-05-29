package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "giohang")
public class GioHang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGH;
	
	@ManyToOne
	@JoinColumn(name="users")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private UserAll users;
	
	@ManyToOne
	@JoinColumn(name="sanphams")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private SanPham sanphams;
	
	@Column(name = "SoLuong")
	private int SoLuong;
	
	
	
}
