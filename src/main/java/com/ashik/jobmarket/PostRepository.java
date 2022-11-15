package com.ashik.jobmarket;
import com.ashik.jobmarket.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
