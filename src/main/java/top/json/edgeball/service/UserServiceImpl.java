package top.json.edgeball.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.json.edgeball.api.UserService;
import top.json.edgeball.consts.ResponseCode;
import top.json.edgeball.domain.repo.UserMapper;
import top.json.edgeball.domain.UserDO;
import top.json.edgeball.domain.service.UserDomainService;
import top.json.edgeball.dto.RegisterDTO;
import top.json.edgeball.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDomainService userDomainService;

    public Response<Long> register(RegisterDTO registerDTO) {
        UserDTO userDTO = registerDTO.getUserDTO();

        if (userDomainService.queryByName(userDTO.getName()) != null) {
            return Response.buildFail(ResponseCode.USERNAME_EXISTED);
        }
        if (userDomainService.queryByMobile(userDTO.getMobile()) != null) {
            return Response.buildFail(ResponseCode.MOBILE_EXISTED);
        }
        userDTO.setId(null);
        try {
            Long id = userDomainService.add(UserDO.newUserDO(userDTO.getId(), userDTO.getName(), userDTO.getPassword(), userDTO.getMobile(), userDTO.getGender()));
            return Response.buildSucess(id);
        } catch (Exception e) {
            return Response.buildFail(ResponseCode.DATABASE_ERROR, e.getMessage());
        }
    }

    public Response<UserDTO> getUser(Long userId) {
        UserDO userDO = userDomainService.get(userId);
        if (userDO == null) {
            return Response.buildFail(ResponseCode.USER_DOES_NOT_EXISTED);
        }
        return Response.buildSucess(UserDTO.newUserDTO(userDO));
    }
}
