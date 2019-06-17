package entities;
// Generated Jun 16, 2019 10:41:42 PM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hoadon generated by hbm2java
 */
@Entity
@Table(name = "hoadon", catalog = "qlnhasach")
public class Hoadon implements java.io.Serializable {

	private Integer id;
	private String maHoaDon;
	private Integer makhachHang;
	private Integer maSach;
	private Integer soLuong;
	private String ngayLap;

	public Hoadon() {
	}

	public Hoadon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Hoadon(String maHoaDon, Integer makhachHang, Integer maSach, Integer soLuong, String ngayLap) {
		this.maHoaDon = maHoaDon;
		this.makhachHang = makhachHang;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.ngayLap = ngayLap;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "maHoaDon", nullable = false, length = 30)
	public String getMaHoaDon() {
		return this.maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	@Column(name = "makhachHang")
	public Integer getMakhachHang() {
		return this.makhachHang;
	}

	public void setMakhachHang(Integer makhachHang) {
		this.makhachHang = makhachHang;
	}

	@Column(name = "maSach")
	public Integer getMaSach() {
		return this.maSach;
	}

	public void setMaSach(Integer maSach) {
		this.maSach = maSach;
	}

	@Column(name = "soLuong")
	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "ngayLap", length = 30)
	public String getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

}
