package com.example.jobsearch.dao;

import com.example.jobsearch.entity.job.Job;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobDAOJpaImpl implements JobDAO {

    private EntityManager entityManager;

    @Autowired
    public JobDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Job> findAll() {
        return new ArrayList<Job>();
    }

    @Override
    public Job findById(int theId) {
        return null;
    }

    @Override
    public Job save(Job job) {
        return null;
    }
}
