package com.ashik.jobmarket.repository;


import com.ashik.jobmarket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
