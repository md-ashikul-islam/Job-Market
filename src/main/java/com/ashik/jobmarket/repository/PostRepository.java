package com.ashik.jobmarket.repository;
import com.ashik.jobmarket.model.Post;
import com.ashik.jobmarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByUser(User user);

    @Query("select p from Post p where p.profile like :key")
    List<Post> searchByTitle(@Param("key") String title);


}
