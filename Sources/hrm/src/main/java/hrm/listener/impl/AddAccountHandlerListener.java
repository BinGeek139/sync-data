package hrm.listener.impl;

import hrm.base.common.exception.BackendError;
import hrm.listener.HandlerListener;
import hrm.modules.core.user.UserService;
import hrm.modules.core.user.dto.UserInternalDTO;
import hrm.modules.core.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddAccountHandlerListener extends HandlerListener<UserInternalDTO> {
    @Autowired
    UserService userService;

    @Override
    protected void execute(UserInternalDTO userInternalDTO) {
        User user=new User();
        user.setFullname(userInternalDTO.getLastName() + " " +userInternalDTO.getLastName())
                .setPassword(userInternalDTO.getPassword())
                .setUsername(userInternalDTO.getUsername());
        try {

            userService.createUser(user);
        } catch (BackendError backendError) {
            backendError.printStackTrace();
        }
    }
}
