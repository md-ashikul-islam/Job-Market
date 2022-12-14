package com.ashik.jobmarket.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="JobPosts")
@Getter@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(nullable = false, length = 100)
    private String profile;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false, length = 100)
    private int experience;
    @Column(nullable = false, length = 100)
    private String techs;

    @ManyToOne
    private User user;

}
