package com.vnpt.eoffice.controller.request;

import com.vnpt.eoffice.domain.Donvichucnang;
import com.vnpt.eoffice.domain.LoaiVanBan;
import com.vnpt.eoffice.domain.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class VanBanRequest {
    @Data
    public static class Create{
        private Integer idDonvichucnang;
        private String maVanBan;
        @NotNull(message = "Tên văn bản không được để trống")
        private String tenVanBan;
        @NotNull(message = "Loại văn bản không được để trống")
        private Integer idLoaiVanBan;
        private String noiDungVanBan;
    }
    @Data
    public static class Submit {
        private String noiDungVanBan;
    }
    @Data
    public static class Update {
        private Integer idDonvichucnang;
        @NotNull(message = "Tên văn bản không được để trống")
        private String tenVanBan;
        @NotNull(message = "Loại văn bản không được để trống")
        private Integer idLoaiVanBan;
        private String noiDungVanBan;
    }
}
