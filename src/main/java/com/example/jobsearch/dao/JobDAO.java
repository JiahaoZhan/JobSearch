package com.example.jobsearch.dao;

import com.example.jobsearch.entity.job.Job;

import java.util.List;

public interface JobDAO {

    List<Job> findAll();
    Job findById(int theId);
    Job save(Job job);
}
