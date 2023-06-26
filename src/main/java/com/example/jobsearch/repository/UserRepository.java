package com.example.jobsearch.repository;

import com.example.jobsearch.entity.user.DAOUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}
