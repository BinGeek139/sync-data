package hrm.listener;

import hrm.listener.impl.AddAccountHandlerListener;
import hrm.listener.impl.AddChucVuHandlerListener;
import hrm.listener.impl.DeleteChuVuHandleListener;
import hrm.listener.impl.UpdateChucVuHandlerListener;

import java.lang.reflect.Type;

public enum ApiSynchronized {
    ADD_ACCOUNT(AddAccountHandlerListener.class),
    RESET_PASS(null),
    CHUC_VU_CREATE(AddChucVuHandlerListener.class),
    CHUC_VU_DELETE(DeleteChuVuHandleListener.class),
    CHUC_VU_UPDATE(UpdateChucVuHandlerListener.class),
    DON_VI_CHUC_NANG_CREATE(null),
    DON_VI_CHUC_NANG_DELETE(null),
    DON_VI_CHUC_NANG_UPDATE(null),
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
