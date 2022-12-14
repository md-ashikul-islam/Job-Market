package com.ashik.jobmarket.services;

import com.ashik.jobmarket.model.Post;
import com.ashik.jobmarket.payloads.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO, Integer  userId);

    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(Integer Id);

    List<PostDTO> getPostsByUser(Integer userId);

    List<PostDTO> searchPost(String keyword);

}
