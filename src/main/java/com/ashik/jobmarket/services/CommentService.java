package com.ashik.jobmarket.services;

import com.ashik.jobmarket.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);

}