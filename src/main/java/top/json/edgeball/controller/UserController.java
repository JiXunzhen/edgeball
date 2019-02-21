package top.json.edgeball.controller;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.json.edgeball.api.UserService;
import top.json.edgeball.dto.RegisterDTO;
import top.json.edgeball.dto.UserDTO;
import top.json.edgeball.service.Response;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/v1")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/get_current_user/{userId}")
    public Response<UserDTO> getCurrentUser(@PathVariable(name = "userId") Long userId) {
        Response<UserDTO> response = userService.getUser(userId);
        if (response.isSuccess()) {
            UserDTO user = response.getData();
            user.setPassword(null);
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response<Long> register(@Valid @RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

    @RequestMapping(value = "mobile_send_code", method = RequestMethod.POST)
    public Response<Null> mobileSendCodeForLogin() {
        return null;
    }

}
