package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.config.SignConf;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.LoaiHang;
import com.example.demo.entity.Quyen;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.TinhTrang;
import com.example.demo.entity.UserAll;
import com.example.demo.reponsitory.GioHangReponsitory;
import com.example.demo.reponsitory.LoaiHangReponsitory;
import com.example.demo.reponsitory.QuyenReponsitory;
import com.example.demo.reponsitory.SanPhamReponsitory;
import com.example.demo.reponsitory.ThuongHieuReponsitory;
import com.example.demo.reponsitory.TinhTrangReponsitory;
import com.example.demo.reponsitory.UserAllReponsitory;
import com.example.demo.service.ThuongHieuService;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	
	
	@Autowired
	private ThuongHieuReponsitory thuonghieuReponsitory;
	
	@Autowired
	private LoaiHangReponsitory loaihangReponsitory;
	
	@Autowired
	private QuyenReponsitory quyenReponsitory;
	
	@Autowired
	private TinhTrangReponsitory tinhtrangReponsitory;

	@Autowired
	private SanPhamReponsitory sanphamReponsitory;
	
	@Autowired
	private UserAllReponsitory userallReponsitory;
	
	@Autowired
	private GioHangReponsitory giahangReponsitory;
	

	
	public void run(String... args) throws Exception{
		
		
		String[] tenThuongHieu = {"Acer","Asus","HP","MSI","LENOVO","RAZER","SAMSUNG","ALIENWARE","APPLE","MICROSOFT","GIGABYTE"}; 
		for(int i=0;i<tenThuongHieu.length;i++)
		{
			ThuongHieu thuonghieu = new ThuongHieu();
			String a = tenThuongHieu[i];
			thuonghieu.setTenTH(a);
			thuonghieuReponsitory.save(thuonghieu);
		}
		
		String[] tenQuyen = {"Admin","Client"};
		for(int i=0;i<tenQuyen.length;i++)
		{
			Quyen quyen = new Quyen();
			quyen.setTenQ(tenQuyen[i]);
			quyenReponsitory.save(quyen);
			
		}
		
		String[] tenTinhTrang = {"Chưa duyệt","Duyệt"};
		for(int i=0;i<tenTinhTrang.length;i++)
		{
			TinhTrang tinhtrang = new TinhTrang();
			tinhtrang.setLoaiTT(tenTinhTrang[i]);
			tinhtrangReponsitory.save(tinhtrang);
			
		}
		
		String[] tenLoaiHang = {"Tai nghe","Laptop","Bàn phím","Chuột","Máy tính"};
		for(int i=0;i<tenLoaiHang.length;i++)
		{
			LoaiHang loaihang = new LoaiHang();
			loaihang.setTenLH(tenLoaiHang[i]);
			loaihangReponsitory.save(loaihang);
			
			
		}
		
		UserAll user1 = new UserAll();
		user1.setEmail("khoa1@gmail.com");
		Quyen quyen1 = quyenReponsitory.getById(1);
		user1.setTenUser("Khoa");
		user1.setTaikhoan("admin");
		user1.setMatkhau("1");
		user1.setSdt("034438883");
		user1.setQuyen(quyen1);
		userallReponsitory.save(user1);
		
		UserAll user2 = new UserAll();
		user2.setEmail("client@gmail.com");
		Quyen quyen2 = quyenReponsitory.getById(2);
		user2.setTenUser("Hung");
		user2.setTaikhoan("client");
		user2.setMatkhau("1");
		user2.setSdt("034438552");
		user2.setQuyen(quyen2);
		userallReponsitory.save(user2);
		
		SanPham sp1 = new SanPham();
		sp1.setGiaSP(5000);
		sp1.setImgSP("https://product.hstatic.net/1000026716/product/1_de3a14a8969c433fbe31ed9ddee5997f_large.jpg");
		LoaiHang loaihang1 = loaihangReponsitory.getById(1);
		sp1.setLoaihang(loaihang1);
		sp1.setMotaSP("hot");
		sp1.setTenSP("viper");
		ThuongHieu th1 = thuonghieuReponsitory.getById(1);
		sp1.setThuonghieu(th1);
		sanphamReponsitory.save(sp1);
////		
		SanPham sp2 = new SanPham();
		sp2.setGiaSP(5000);
		sp2.setImgSP("https://product.hstatic.net/1000026716/product/laptop_gaming_acer_aspire_7_a715_42g_r05g_f9b4034f328d4211b9ffe51f7b1c4cbf_large.jpg");
////		LoaiHang loaihang1 = loaihangReponsitory.getById(1);
		sp2.setLoaihang(loaihang1);
		sp2.setMotaSP("Đầu tư vào một bộ PC đúng cách luôn là vấn đề nan giải đối với dân công nghệ nói chung và game thủ nói riêng. Bởi vì nếu không tìm hiểu hoặc được tư vấn kỹ lưỡng, các bạn sẽ rất dễ bỏ tiền ra mua những linh kiện không thật sự phù hợp");
		sp2.setTenSP("super");
////		ThuongHieu th1 = thuonghieuReponsitory.getById(1);
		sp2.setThuonghieu(th1);
		sanphamReponsitory.save(sp2);
//		
		SanPham sp3 = new SanPham();
		sp3.setGiaSP(5000);
		sp3.setImgSP("https://product.hstatic.net/1000026716/product/thumbphim-recovered_20c9ea1670d542febe58b1e6c9872dba_large.png");
////		LoaiHang loaihang1 = loaihangReponsitory.getById(1);
		sp3.setLoaihang(loaihang1);
		sp3.setMotaSP("hot");
		sp3.setTenSP("wiper");
////		ThuongHieu th1 = thuonghieuReponsitory.getById(1);
		sp3.setThuonghieu(th1);
		sanphamReponsitory.save(sp3);
////		
		SanPham sp4 = new SanPham();
		sp4.setGiaSP(5000);
		sp4.setImgSP("https://product.hstatic.net/1000026716/product/gearvn-tai-nghe-logitech-g535-lightspeed-wireless-black-1_4185ee7505e341c3a8ad51b2c87009b1.png");
////		LoaiHang loaihang1 = loaihangReponsitory.getById(1);
		sp4.setLoaihang(loaihang1);
		sp4.setMotaSP("hot");
		sp4.setTenSP("noce");
////		ThuongHieu th1 = thuonghieuReponsitory.getById(1);
		sp4.setThuonghieu(th1);
		sanphamReponsitory.save(sp4);
////		
		SanPham sp5= new SanPham();
		sp5.setGiaSP(5000);
		sp5.setImgSP("https://product.hstatic.net/1000026716/product/ram_kingston_ddr4_ecc_1x16g_2666mhz_reg_cl19_60a5bcc75df443ebbb2f39c2d3be1a09_large.png");
////		LoaiHang loaihang1 = loaihangReponsitory.getById(1);
		sp5.setLoaihang(loaihang1);
		sp5.setMotaSP("hot");
		sp5.setTenSP("viper5");
////		ThuongHieu th1 = thuonghieuReponsitory.getById(1);
		sp5.setThuonghieu(th1);
		sanphamReponsitory.save(sp5);
		
		SanPham sp6= new SanPham();
		sp6.setGiaSP(5000);
		sp6.setImgSP("https://product.hstatic.net/1000026716/product/l1421w_2b115562199d462b82b92e89e95b2473_large.png");
		LoaiHang loaihang2 = loaihangReponsitory.getById(2);
		sp6.setLoaihang(loaihang2);
		sp6.setMotaSP("hot");
		sp6.setTenSP("viper6");
		ThuongHieu th2 = thuonghieuReponsitory.getById(2);
		sp6.setThuonghieu(th2);
		sanphamReponsitory.save(sp6);
//		
		SanPham sp7= new SanPham();
		sp7.setGiaSP(9000);
		sp7.setImgSP("https://product.hstatic.net/1000026716/product/va2732-mh_f01_pc_h_cf324ffb0be84db4b7a0a78a56264cb5_145cf02bb38445f1987bc18a72d15e17_large.jpg");
		LoaiHang loaihang3 = loaihangReponsitory.getById(3);
		sp7.setLoaihang(loaihang3);
		sp7.setMotaSP("hot");
		sp7.setTenSP("viper7");
		ThuongHieu th3 = thuonghieuReponsitory.getById(3);
		sp7.setThuonghieu(th3);
		sanphamReponsitory.save(sp7);
//		
//		GioHang gh1 = new GioHang();
//		gh1.setSanphams(sanphamReponsitory.getById(1));
//		gh1.setSoLuong(20);
//		gh1.setUsers(userallReponsitory.getById(2));
//		giahangReponsitory.save(gh1);
////		
//		GioHang gh2 = new GioHang();
//		gh2.setSanphams(sanphamReponsitory.getById(2));
//		gh2.setSoLuong(10);
//		gh2.setUsers(userallReponsitory.getById(1));
//		giahangReponsitory.save(gh2);
//	
		
//		List<ThuongHieu> thuonghieus = thuonghieuSer.getThuongHieus();
//		System.out.print(thuonghieus);
//		System.out.print(thuonghieuReponsitory.findAll());
//		ThuongHieu thuonghieu = new ThuongHieu();
//		thuonghieu.setIdTH(1);
//		thuonghieu.setTenTH("hoc hoi");
//		thuonghieu.setSanphams(null);
//		thuonghieuReponsitory.save(thuonghieu);
		
	}
	
	
	
	
}
