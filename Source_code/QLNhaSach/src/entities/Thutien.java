package entities;
// Generated Jun 16, 2019 10:41:42 PM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Thutien generated by hbm2java
 */
@Entity
@Table(name = "thutien", catalog = "qlnhasach")
public class Thutien implements java.io.Serializable {

	private Integer id;
	private Integer maKh;
	private Integer tienThu;
	private String ngayThu;

	public Thutien() {
	}

	public Thutien(Integer maKh, Integer tienThu, String ngayThu) {
		this.maKh = maKh;
		this.tienThu = tienThu;
		this.ngayThu = ngayThu;
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

	@Column(name = "maKH")
	public Integer getMaKh() {
		return this.maKh;
	}

	public void setMaKh(Integer maKh) {
		this.maKh = maKh;
	}

	@Column(name = "tienThu")
	public Integer getTienThu() {
		return this.tienThu;
	}

	public void setTienThu(Integer tienThu) {
		this.tienThu = tienThu;
	}

	@Column(name = "ngayThu", length = 50)
	public String getNgayThu() {
		return this.ngayThu;
	}

	public void setNgayThu(String ngayThu) {
		this.ngayThu = ngayThu;
	}

}
