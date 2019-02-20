package top.json.edgeball.dto;


import org.apache.catalina.User;
import top.json.edgeball.domain.UserDO;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 9186424189151989018L;

    private Long id;
    private String name;
    private String password;
    private String mobile;
    private Short gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public static UserDTO newUserDTO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDO.getId());
        userDTO.setName(userDO.getName());
        userDTO.setPassword(userDO.getPassword());
        userDTO.setMobile(userDO.getMobile());
        userDTO.setGender(userDO.getGender());
        return userDTO;
    }
}
