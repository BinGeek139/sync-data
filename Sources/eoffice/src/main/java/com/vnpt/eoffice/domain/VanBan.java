package com.vnpt.eoffice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "vanBan")
public class VanBan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donViChucNangQd_pk", foreignKey = @ForeignKey(name = "donViChucNangQd_pk"),nullable = true)
	private Donvichucnang donvichucnang;

	private Integer idNguoiTao;
	private Timestamp ngayTao;


	private String maVanBan;

	private String tenVanBan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loaVanBan_id")
	private LoaiVanBan loaiVanBan;

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	private String noiDungVanBan;


	private Integer nguoiPheDuyet;
	private Timestamp ngayPheDyet;

	private Integer nguoiBanHanh;
	private Timestamp ngayBanHanh;

	private Integer isExist;
	private Timestamp ngayXoa;



}
