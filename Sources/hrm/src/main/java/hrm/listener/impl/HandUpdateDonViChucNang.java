package hrm.listener.impl;

import hrm.domain.model.dto.DonViChucNangDTO;
import hrm.domain.service.DonViChucNangServiceImpl;
import hrm.listener.HandlerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandUpdateDonViChucNang extends HandlerListener<DonViChucNangDTO> {
     @Autowired
     DonViChucNangServiceImpl donViChucNangService;
    @Override
    protected void execute(DonViChucNangDTO donViChucNangDTO) {
        donViChucNangService.update(donViChucNangDTO);
    }
}
