package com.ashik.jobmarket.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private Integer postId;
    private String profile;
    private String description;

    private int experience;
    private String techs;
    private UserDTO user;
}
