package entities;
// Generated Jun 16, 2019 10:41:42 PM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Theloai generated by hbm2java
 */
@Entity
@Table(name = "theloai", catalog = "qlnhasach")
public class Theloai implements java.io.Serializable {

	private Integer id;
	private String tenTheLoai;

	public Theloai() {
	}

	public Theloai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
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

	@Column(name = "tenTheLoai", length = 100)
	public String getTenTheLoai() {
		return this.tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

}
