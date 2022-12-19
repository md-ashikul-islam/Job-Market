package com.ashik.jobmarket.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Set<CommentDto> comments=new HashSet<>();
}
