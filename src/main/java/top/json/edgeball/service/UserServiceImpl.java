package top.json.edgeball.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.json.edgeball.api.UserService;
import top.json.edgeball.consts.ResponseCode;
import top.json.edgeball.dao.UserMapper;
import top.json.edgeball.domain.UserDO;
import top.json.edgeball.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Response<Long> register(UserDTO userDTO) {
        userDTO.setId(null);
        try {
            Long id = userMapper.insert(UserDO.newUserDO(userDTO.getId(), userDTO.getName(), userDTO.getPassword(), userDTO.getMobile(), userDTO.getGender()));
            return Response.buildSucess(id);
        } catch (Exception e) {
            return Response.buildFail(ResponseCode.DATABASE_ERROR, e.getMessage());
        }
    }

    public Response<UserDTO> getUser(Long userId) {
        UserDO userDO = userMapper.get(userId);
        if (userDO == null) {
            return Response.buildFail(ResponseCode.USER_DOES_NOT_EXIST);
        }
        return Response.buildSucess(UserDTO.newUserDTO(userDO));
    }
}
