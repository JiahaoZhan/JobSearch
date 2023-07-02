package com.example.jobsearch.service.user;

import com.example.jobsearch.entity.user.UserDAO;
import com.example.jobsearch.entity.user.UserDTO;
import com.example.jobsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserDAO findUserByEmail(String email) {
        UserDAO dao = userRepo.findByEmail(email);
        return dao;
    }
}
