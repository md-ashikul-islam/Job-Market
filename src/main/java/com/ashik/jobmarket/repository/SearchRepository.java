package com.ashik.jobmarket.repository;
import com.ashik.jobmarket.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SearchRepository{

    List<Post> findByText(String text);
}
