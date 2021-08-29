package com.vnpt.eoffice.controller.listener;

import com.vnpt.eoffice.controller.listener.impl.*;

import java.lang.reflect.Type;

public enum ApiSynchronized {
    ADD_ACCOUNT(AddChucVuHandlerListener.class),
    RESET_PASS(ResetPassHandlerListener.class),
    CHUC_VU_CREATE(AddChucVuHandlerListener.class),
    CHUC_VU_DELETE(DeleteChuVuHandleListener.class),
    CHUC_VU_UPDATE(UpdateChucVuHandlerListener.class),
    DON_VI_CHUC_NANG_CREATE(CreateDonViChucNangHandlerListener.class),
    DON_VI_CHUC_NANG_DELETE(DeleteDonViChucNangHandlerListener.class),
    DON_VI_CHUC_NANG_UPDATE(UpdateChucVuHandlerListener.class),
    ;
    Type classHandler;

    ApiSynchronized(Type classHandler) {
        this.classHandler = classHandler;
    }

    public Type getClassHandler() {
        return classHandler;
    }

    public void setClassHandler(Type classHandler) {
        this.classHandler = classHandler;
    }
}
