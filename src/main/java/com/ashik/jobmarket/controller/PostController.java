//package com.ashik.jobmarket.controller;
//
//import com.ashik.jobmarket.repository.PostRepository;
//import com.ashik.jobmarket.model.Post;
//import com.ashik.jobmarket.repository.SearchRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class PostController {
//
//    @Autowired
//    PostRepository repo;
//    @Autowired
//    SearchRepository srepo;
//
//    @GetMapping("/allPosts")
//    @CrossOrigin
//    public List<Post> getAllPosts(){
//        return repo.findAll();
//    }
//
//    @GetMapping("/posts/{text}")
//    @CrossOrigin
//    public List<Post> search(@PathVariable String text){
//        return srepo.findByText(text);
//    }
//
//
//    @PostMapping("/post")
//    @CrossOrigin
//    public Post addPost(@RequestBody Post post){
//        return repo.save(post);
//    }
//
//
//
//}
