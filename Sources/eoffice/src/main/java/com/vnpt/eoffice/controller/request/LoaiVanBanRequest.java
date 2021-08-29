package com.vnpt.eoffice.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoaiVanBanRequest {
    @NotNull(message = "Tên  không được để trống")
    private String ten;
    private String moTa;

}
