package model;
// Generated Mar 31, 2019 3:24:52 PM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Quydinh generated by hbm2java
 */
@Entity
@Table(name = "quydinh", catalog = "da_java")
public class Quydinh implements java.io.Serializable {

	private Integer id;
	private Integer nhaptoithieu;
	private Integer tonToiThieuNhap;
	private Integer tonToiThieuBan;
	private Long tienNoToiDa;
	private Integer hieuLuc;

	public Quydinh() {
	}

	public Quydinh(Integer nhaptoithieu, Integer tonToiThieuNhap, Integer tonToiThieuBan, Long tienNoToiDa,
			Integer hieuLuc) {
		this.nhaptoithieu = nhaptoithieu;
		this.tonToiThieuNhap = tonToiThieuNhap;
		this.tonToiThieuBan = tonToiThieuBan;
		this.tienNoToiDa = tienNoToiDa;
		this.hieuLuc = hieuLuc;
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

	@Column(name = "nhaptoithieu")
	public Integer getNhaptoithieu() {
		return this.nhaptoithieu;
	}

	public void setNhaptoithieu(Integer nhaptoithieu) {
		this.nhaptoithieu = nhaptoithieu;
	}

	@Column(name = "tonToiThieuNhap")
	public Integer getTonToiThieuNhap() {
		return this.tonToiThieuNhap;
	}

	public void setTonToiThieuNhap(Integer tonToiThieuNhap) {
		this.tonToiThieuNhap = tonToiThieuNhap;
	}

	@Column(name = "tonToiThieuBan")
	public Integer getTonToiThieuBan() {
		return this.tonToiThieuBan;
	}

	public void setTonToiThieuBan(Integer tonToiThieuBan) {
		this.tonToiThieuBan = tonToiThieuBan;
	}

	@Column(name = "tienNoToiDa", precision = 11, scale = 0)
	public Long getTienNoToiDa() {
		return this.tienNoToiDa;
	}

	public void setTienNoToiDa(Long tienNoToiDa) {
		this.tienNoToiDa = tienNoToiDa;
	}

	@Column(name = "hieuLuc")
	public Integer getHieuLuc() {
		return this.hieuLuc;
	}

	public void setHieuLuc(Integer hieuLuc) {
		this.hieuLuc = hieuLuc;
	}

}
