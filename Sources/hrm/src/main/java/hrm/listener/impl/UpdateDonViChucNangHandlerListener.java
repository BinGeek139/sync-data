package hrm.listener.impl;

import hrm.domain.model.dto.DonViChucNangDTO;
import hrm.domain.service.DonViChucNangServiceImpl;
import hrm.listener.HandlerListener;
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
