package com.ashik.jobmarket.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter@Setter
public class UserDTO {

    private int id;
    @NotEmpty
    private String name;
    @Email(message = "Email address is not valid!") @NotEmpty
    private String email;
    @NotEmpty
    @Size(min =4,max=10, message = "Password must be minimum of 3 characters and maximum 10 characters!")
    private String password;
    private Set<RoleDTO> roles = new HashSet<>();
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password=password;
    }

}
