package com.ashik.jobmarket.repository;

import com.ashik.jobmarket.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

}