package com.vnpt.eoffice.dto;

import com.vnpt.eoffice.domain.Donvichucnang;
import com.vnpt.eoffice.domain.LoaiVanBan;
import com.vnpt.eoffice.domain.Status;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
public class VanBanDto {

    private Integer id;
    private DonViChucNangDTO donViChucNangDTO;
    private Integer idNguoiTao;
    private Timestamp ngayTao;
    private String maVanBan;
    private String tenVanBan;
    private LoaiVanBan loaiVanBan;
    private Status status;
    private String noiDungVanBan;
    private Integer nguoiPheDuyet;
    private Timestamp ngayPheDyet;
    private Integer nguoiBanHanh;
    private Timestamp ngayBanHanh;
}
