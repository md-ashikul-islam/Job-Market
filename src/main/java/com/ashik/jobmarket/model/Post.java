package com.ashik.jobmarket.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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
    private Date addedDate;
    @Column(nullable = false, length = 100)
    private String techs;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments=new HashSet<>();

}
