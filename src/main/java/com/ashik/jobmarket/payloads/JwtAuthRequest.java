package com.ashik.jobmarket.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {

    private String username;

    private String password;

}