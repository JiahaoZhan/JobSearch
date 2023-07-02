package com.example.jobsearch.repository;

import com.example.jobsearch.entity.user.UserDAO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDAO, Integer> {
    UserDAO findByEmail(String email);
}
