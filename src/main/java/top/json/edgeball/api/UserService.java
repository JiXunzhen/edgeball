package top.json.edgeball.api;

import top.json.edgeball.dto.RegisterDTO;
import top.json.edgeball.dto.UserDTO;
import top.json.edgeball.service.Response;

public interface UserService {
    Response<UserDTO> getUser(Long userId);
    Response<Long> register(RegisterDTO registerDTO);
}
