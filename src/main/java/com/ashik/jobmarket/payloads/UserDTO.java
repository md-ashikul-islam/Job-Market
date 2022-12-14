package com.ashik.jobmarket.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter@Setter
public class UserDTO {

    private int id;
    @NotEmpty
    private String name;
    @Email(message = "Email address is not valid!") @NotEmpty
    private String email;
    @NotEmpty
    @Size(min =4, max=10, message = "Password must be minimum of 3 characters and maximum 10 characters!")
    private String password;
}
