package com.vnpt.eoffice.controller.listener.impl;

import com.vnpt.eoffice.controller.listener.HandlerListener;
import com.vnpt.eoffice.dto.DonViChucNangDTO;
import com.vnpt.eoffice.service.impl.DonViChucNangServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateDonViChucNangHandlerListener extends HandlerListener<DonViChucNangDTO> {
    @Autowired
    DonViChucNangServiceImpl donViChucNangService;
    @Override
    protected void execute(DonViChucNangDTO donViChucNangDTO) {
donViChucNangService.update(donViChucNangDTO);
    }
}
