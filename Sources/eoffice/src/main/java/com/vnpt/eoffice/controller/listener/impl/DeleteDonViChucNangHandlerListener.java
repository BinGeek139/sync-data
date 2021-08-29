package com.vnpt.eoffice.controller.listener.impl;

import com.vnpt.eoffice.controller.listener.HandlerListener;
import com.vnpt.eoffice.repository.IDonViChucNangRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteDonViChucNangHandlerListener extends HandlerListener<Integer> {
    @Autowired
    IDonViChucNangRepository iDonViChucNangRepository;
    @Override
    protected void execute(Integer integer) {
        iDonViChucNangRepository.delete(iDonViChucNangRepository.getOne(integer));
    }
}
