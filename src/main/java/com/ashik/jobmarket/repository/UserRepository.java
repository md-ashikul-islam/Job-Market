package com.ashik.jobmarket.repository;


import com.ashik.jobmarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
