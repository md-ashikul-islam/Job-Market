package com.ashik.jobmarket.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private Integer postId;
    private String profile;
    private String description;
    private Date addedDate;
    private int experience;
    private String techs;
    private UserDTO user;
}
