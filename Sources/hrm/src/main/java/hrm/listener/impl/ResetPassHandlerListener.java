package hrm.listener.impl;

import hrm.listener.HandlerListener;
import hrm.modules.core.user.UserService;
import hrm.modules.core.user.dto.ResetPasswordRequest;
import hrm.modules.core.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ResetPassHandlerListener  extends HandlerListener<ResetPasswordRequest> {
    @Autowired
    UserService userService;
    @Override
    protected void execute(ResetPasswordRequest resetPasswordRequest) {
        User user = userService.getByUsername(resetPasswordRequest.getUserName());
        userService.updateUserPassword(user,resetPasswordRequest.getUserName());
    }
}
