package com.vnpt.eoffice.controller.listener.impl;

import com.vnpt.eoffice.controller.listener.HandlerListener;
import com.vnpt.eoffice.dto.ChucVuDTO;
import com.vnpt.eoffice.service.IChucVuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeleteChuVuHandleListener  extends HandlerListener<Integer> {
    @Autowired
    IChucVuService iChucVuService;

    @Override
    protected void execute(Integer integer) {
        iChucVuService.delete(integer);
    }
}
