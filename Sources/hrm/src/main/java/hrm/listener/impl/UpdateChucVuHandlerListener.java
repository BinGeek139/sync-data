package hrm.listener.impl;


import hrm.domain.model.dto.ChucVuDTO;
import hrm.domain.service.IChucVuService;
import hrm.listener.HandlerListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateChucVuHandlerListener  extends HandlerListener<ChucVuDTO> {
    @Autowired
    IChucVuService iChucVuService;
    @Override

    protected void execute(ChucVuDTO chucVuDTO) {
        iChucVuService.update(chucVuDTO);
    }
}
