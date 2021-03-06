package top.json.edgeball.domain;

import lombok.Getter;
import lombok.Setter;
import top.json.edgeball.dto.UserDTO;

import java.io.Serializable;

public class UserDO {
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

    public static UserDO newUserDO(Long id, String name, String password, String mobile, Short gender) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        userDO.setPassword(password);
        userDO.setName(name);
        userDO.setGender(gender);
        userDO.setMobile(mobile);
        return userDO;
    }
}
