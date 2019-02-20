package top.json.edgeball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.json.edgeball.api.UserService;
import top.json.edgeball.dto.UserDTO;
import top.json.edgeball.service.Response;

@RestController
@RequestMapping("/user/v1")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/get_current_user/{userId}")
    public Response<UserDTO> getCurrentUser(Long userId) {
        Response<UserDTO> response = userService.getUser(userId);
        if (response.isSuccess()) {
            UserDTO user = response.getData();
            user.setPassword(null);
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Response<Long> register(UserDTO userDTO) {
        return userService.register(userDTO);
    }
}
