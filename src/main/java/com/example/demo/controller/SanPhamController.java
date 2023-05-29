package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.SignConf;
import com.example.demo.entity.DatHang;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.TinhTrang;
import com.example.demo.entity.UserAll;
import com.example.demo.service.DatHangService;
import com.example.demo.service.GioHangService;
import com.example.demo.service.LoaiHangService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThuongHieuService;
import com.example.demo.service.TinhTrangService;
import com.example.demo.service.UserAllService;

@Controller
public class SanPhamController {
	@Autowired
	private SanPhamService sanphamService;
	
	@Autowired
	private ThuongHieuService thuonghieuService;
	
	
	@Autowired
	private DatHangService dathangService;
	
	@Autowired
	private TinhTrangService tinhtrangService;
	
	@Autowired
	private GioHangService giohangService;
	
	@Autowired
	private UserAllService userService;
	
	
	
	@Autowired
	private LoaiHangService loaihangService;

	private SignConf signconf;
	
	public SanPhamController(SanPhamService sanphamService) {
		super();
		this.sanphamService = sanphamService;
	}
    
	@GetMapping("/")
	public String listSanPhams(Model model) {
		ArrayList<String> listthsp = new ArrayList<String>();
		ArrayList<String> listlhsp = new ArrayList<String>();
		ArrayList<String> titlethsp = new ArrayList<String>();
		ArrayList<String> titlelhsp = new ArrayList<String>();
//		signconf.idSign = 2;
		int idU = signconf.idSign;
		for(int i=0;i<sanphamService.getSanPhams().size();i++) {
			boolean check = true;
			for(String q : listthsp) {
				if( Integer.parseInt(q) == sanphamService.getSanPhams().get(i).getThuonghieu().getIdTH()) {
					check = false;
					break;
				}
			}
			if(check == true) {
				listthsp.add(String.valueOf(sanphamService.getSanPhams().get(i).getThuonghieu().getIdTH()));
				titlethsp.add(sanphamService.getSanPhams().get(i).getThuonghieu().getTenTH());
			}
			
			
			boolean check2 = true;
			for(String q : listlhsp) {
				if( Integer.parseInt(q) == sanphamService.getSanPhams().get(i).getLoaihang().getIdLH()) {
					check2 = false;
					break;
				}
			}
			if(check2 == true) {
				listlhsp.add(String.valueOf(sanphamService.getSanPhams().get(i).getLoaihang().getIdLH()));
				titlelhsp.add(sanphamService.getSanPhams().get(i).getLoaihang().getTenLH());
			}
			
		}
		
//		for(String i : listthsp) {
//			String a = "sanphams" + i;
//			model.addAttribute(a,sanphamService.getSpLoaiHangs(Integer.parseInt(i)));
//
//		}
		
		for( int i=0;i<listthsp.size();i++) {
			String b = "titleTH" + listthsp.get(i);
			model.addAttribute(b,titlethsp.get(i));
			String a = "sanphams" + listthsp.get(i);
			model.addAttribute(a,sanphamService.getSpThuongHieus(Integer.parseInt(listthsp.get(i))));
		}
		
		for( int i=0;i<listlhsp.size();i++) {
			String b = "titleLH" + listlhsp.get(i);
			model.addAttribute(b,titlelhsp.get(i));
			String a = "sanphamLHs" + listlhsp.get(i);
			model.addAttribute(a,sanphamService.getSpLoaiHangs(Integer.parseInt(listlhsp.get(i))));
		}
		model.addAttribute("giohangs",giohangService.getByIDGH(idU));
		model.addAttribute("usersign", userService.getUserID(idU));
		System.out.println(titlethsp); 
		System.out.println(listthsp); 
		
		return "index";
	}
	
	@GetMapping("/sanphams")
	public String listSanPham2s(Model model) {
	
		model.addAttribute("sanphams",sanphamService.getSanPhams());
		return "sanpham";
	}
	
	@GetMapping("/sanphams/new")
	public String createSanPham(Model model) {
//		System.out.println(sanphamService.getSanPhams());
		SanPham sp = new SanPham();
		model.addAttribute("sanpham", sp);
		model.addAttribute("thuonghieus",thuonghieuService.getThuongHieus());
		model.addAttribute("loaihangs",loaihangService.getLoaiHangs());
		return "create_sanpham";
	}
	
	@PostMapping("/sanphams")
	public String saveSP(@ModelAttribute("sanphams") SanPham sp)
	{
		sanphamService.saveSanPham(sp);
		return "redirect:/sanphams";
	}
 
	@GetMapping("/sanphams/edit/{idSP}")
	public String editSanPham(@PathVariable int idSP, Model model) {
		model.addAttribute("sanpham", sanphamService.getById(idSP));
		model.addAttribute("thuonghieus",thuonghieuService.getThuongHieus());
		model.addAttribute("loaihangs",loaihangService.getLoaiHangs());
		return "edit_sanpham";
	}
	
	
	
	@PostMapping("/sanphams/{idSP}")
	public String updateSP(@PathVariable int idSP,@ModelAttribute("sanpham") SanPham sp,Model model)
	{
		SanPham sanpham = sanphamService.getById(idSP);
		sanpham.setIdSP(idSP);
		sanpham.setGiaSP(sp.getGiaSP());
		sanpham.setImgSP(sp.getImgSP());
		sanpham.setLoaihang(sp.getLoaihang());
		sanpham.setMotaSP(sp.getMotaSP());
		sanpham.setTenSP(sp.getTenSP());
		sanpham.setThuonghieu(sp.getThuonghieu());
		
		sanphamService.saveSanPham(sanpham);
		return "redirect:/sanphams";
	}
	
	@GetMapping("/sanphams/{idSP}")
	public String deleteSP(@PathVariable int idSP)
	{
		sanphamService.deletesp(idSP);
		return "redirect:/sanphams";
	}
	
	@GetMapping("/sanphams/cart-add/{idGH}")
	public String cartaddSP(@PathVariable int idGH)
	{
		giohangService.cartadd(idGH);
		return "redirect:/";
	}
	@GetMapping("/sanphams/cart-minus/{idGH}")
	public String cartminusSP(@PathVariable int idGH)
	{
		giohangService.cartminus(idGH);
		return "redirect:/";
	}
	
	@GetMapping("/sanphams/cart-delete/{idGH}")
	public String cartdeleteSP(@PathVariable int idGH)
	{
		giohangService.cartdelete(idGH);
		return "redirect:/";
	}
	
	@GetMapping("/sanphams/order/{idU}")
	public String orderSP(@PathVariable int idU,Model model)
	{
		model.addAttribute("giohangs",giohangService.getByIDGH(idU));
		model.addAttribute("total",giohangService.totalPrice(idU));
		return "order";
	}
	
	@GetMapping("/sanphams/order-delete/{idGH}")
	public String orderdelete(@PathVariable int idGH)
	{
		giohangService.cartdelete(idGH);
		String link = "redirect:/sanphams/order/"+signconf.idSign;
		return link;
	}
	
	@GetMapping("/login")
	public String Login(Model model)
	{
		UserAll user = new UserAll();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/user/signin")
	public String userSign(@ModelAttribute("user") UserAll user,Model model)
	{
		
//		System.out.println(user.getTaikhoan() + user.getMatkhau() + " ok");
		int idU = userService.checkinuser(user.getTaikhoan(), user.getMatkhau());
//		System.out.println(idU);
		if(idU == 0) {
			return "redirect:/login";
		}
		signconf.idSign = idU;
		return "redirect:/";
	}
	
	@GetMapping("/sanpham-detail/{idSP}")
	public String detailsp(@PathVariable int idSP,Model model)
	{
		model.addAttribute("sanpham",sanphamService.getById(idSP));
		return "order-delivery";
	}
	
	@GetMapping("/sanpham-detail/add/{idSP}")
	public String addghsp(@PathVariable int idSP)
	{
	
		GioHang gHang = new GioHang();
		gHang.setSanphams(sanphamService.getById(idSP));
		gHang.setSoLuong(1);
		gHang.setUsers(userService.getUserID(signconf.idSign));
		giohangService.saveGH(gHang);
		return "redirect:/";
	}
	
	@GetMapping("/dathangs/new")
	public String payment(Model model)
	{
		DatHang dh = new DatHang();
		model.addAttribute("dathang",dh);
		return "payment";
	}
	
	@PostMapping("/dathangs/delivery")
	public String userSign(@ModelAttribute("dathang") DatHang dh)
	{
		
		for(GioHang a : giohangService.getByIDGH(signconf.idSign)) {
			DatHang dathang = new DatHang();
			dathang.setDiaChi(dh.getDiaChi());
			dathang.setSanphams(a.getSanphams());
			dathang.setSoLuong(a.getSoLuong());
			TinhTrang tt = tinhtrangService.getTT(1);
			dathang.setTinhtrangs(tt);
			UserAll user = userService.getUserID(signconf.idSign);
			dathang.setUsers(user);
			dathangService.save(dathang);
			giohangService.deleteGHID(signconf.idSign);
		}
		return "redirect:/";
	}
	
	@GetMapping("/setidsign/default")
	public String setidsign() {
		signconf.idSign = 0;
		return "redirect:/";
	}
	
	@GetMapping("/dathangs")
	public String DatHangID( Model model) {
		model.addAttribute("dathangs",dathangService.getDatHangs());
		return "dathang";
	}
	
	@GetMapping("/dathangs/accept/{idDH}")
	public String acceptDH(@PathVariable int idDH, Model model) {
		DatHang dh = dathangService.getByID(idDH);
		dh.setIdDH(idDH);
		dh.setTinhtrangs(tinhtrangService.getTT(2));
		dathangService.save(dh);
		return "redirect:/dathangs";
	}
	
	@GetMapping("/dathangs/{idDH}")
	public String deleteDH(@PathVariable int idDH)
	{
		dathangService.delete(idDH);
		return "redirect:/dathangs";
	}
	
	
	@GetMapping("/users")
	public String listuser(Model model) {
	
		model.addAttribute("users", userService.getUserAlls());
		return "user";
	}
	
	@GetMapping("/users/edit/{idUser}")
	public String editUser(@PathVariable int idUser, Model model) {
		model.addAttribute("user", userService.getUserID(idUser));
		
		return "edit_user";
	}
	
	@GetMapping("/users/{idUser}")
	public String editUser(@PathVariable int idUser) {
		userService.deletebyID(idUser);
		
		return "redirect:/users";
	}
	
	
	@PostMapping("/users/{idUser}")
	public String updateSP(@PathVariable int idUser,@ModelAttribute("user") UserAll user,Model model)
	{
		UserAll u = userService.getUserID(idUser);
		u.setEmail(user.getEmail());
		u.setIdUser(idUser);
		u.setMatkhau(user.getMatkhau());
		u.setSdt(user.getSdt());
		u.setTaikhoan(user.getTaikhoan());
		u.setTenUser(user.getTenUser());
		
		userService.save(u);
		return "redirect:/users";
	}
	
}
