package com.vnpt.eoffice.controller.listener.impl;

import com.vnpt.eoffice.controller.listener.HandlerListener;
import com.vnpt.eoffice.controller.request.ResetPasswordRequest;
import com.vnpt.eoffice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResetPassHandlerListener extends HandlerListener<ResetPasswordRequest> {
    UserService userService;
    @Override
    protected void execute(ResetPasswordRequest resetPasswordRequest) {
        userService.resetPassword(resetPasswordRequest);
    }
}
