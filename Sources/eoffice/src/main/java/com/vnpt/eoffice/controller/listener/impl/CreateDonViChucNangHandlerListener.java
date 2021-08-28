package com.vnpt.eoffice.controller.listener.impl;

import com.vnpt.eoffice.controller.listener.HandlerListener;
import com.vnpt.eoffice.dto.DonViChucNangDTO;
import com.vnpt.eoffice.service.IDonViChucNangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateDonViChucNangHandlerListener extends HandlerListener<DonViChucNangDTO> {
    IDonViChucNangService iDonViChucNangService;
    @Override
    protected void execute(DonViChucNangDTO donViChucNangDTO) {
        iDonViChucNangService.insert(donViChucNangDTO);
    }
}
