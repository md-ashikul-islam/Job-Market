package com.ashik.jobmarket.services;

import com.ashik.jobmarket.model.Post;
import com.ashik.jobmarket.payloads.PostDTO;
import com.ashik.jobmarket.payloads.PostResponse;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO, Integer  userId);

    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    PostDTO getPostById(Integer Id);

    List<PostDTO> getPostsByUser(Integer userId);

    List<PostDTO> searchPost(String keyword);

}
