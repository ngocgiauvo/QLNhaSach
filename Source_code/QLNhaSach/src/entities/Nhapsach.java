package entities;
// Generated May 2, 2019 2:17:24 PM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nhapsach generated by hbm2java
 */
@Entity
@Table(name = "nhapsach", catalog = "qlnhasach")
public class Nhapsach implements java.io.Serializable {

	private Integer id;
	private String ngayNhap;
	private Integer maSach;
	private Integer soLuongTon;
	private Integer soLuongNhap;

	public Nhapsach() {
	}

	public Nhapsach(String ngayNhap, Integer maSach, Integer soLuongTon, Integer soLuongNhap) {
		this.ngayNhap = ngayNhap;
		this.maSach = maSach;
		this.soLuongTon = soLuongTon;
		this.soLuongNhap = soLuongNhap;
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

	@Column(name = "ngayNhap", length = 30)
	public String getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Column(name = "maSach")
	public Integer getMaSach() {
		return this.maSach;
	}

	public void setMaSach(Integer maSach) {
		this.maSach = maSach;
	}

	@Column(name = "soLuongTon")
	public Integer getSoLuongTon() {
		return this.soLuongTon;
	}

	public void setSoLuongTon(Integer soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	@Column(name = "soLuongNhap")
	public Integer getSoLuongNhap() {
		return this.soLuongNhap;
	}

	public void setSoLuongNhap(Integer soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}

}
