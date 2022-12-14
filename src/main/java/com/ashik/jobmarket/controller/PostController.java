package com.ashik.jobmarket.controller;

import com.ashik.jobmarket.payloads.PostDTO;
import com.ashik.jobmarket.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
//@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/user/{userId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,@PathVariable Integer userId){
        PostDTO createPost = this.postService.createPost(postDTO, userId);
        return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
    }

    // get by user

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId) {

        List<PostDTO> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
    }

}
