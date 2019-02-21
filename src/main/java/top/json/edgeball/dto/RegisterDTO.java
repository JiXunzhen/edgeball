package top.json.edgeball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class RegisterDTO {
    @JsonProperty(value = "userParam")
    @NotNull
    private UserDTO userDTO;

    @JsonProperty(value = "validateCodeParam")
    @NotNull
    private ValidateCodeDTO validateCodeDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ValidateCodeDTO getValidateCodeDTO() {
        return validateCodeDTO;
    }

    public void setValidateCodeDTO(ValidateCodeDTO validateCodeDTO) {
        this.validateCodeDTO = validateCodeDTO;
    }
}
