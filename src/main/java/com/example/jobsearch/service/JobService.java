package com.example.jobsearch.service;

import com.example.jobsearch.entity.job.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    List<Job> search(SearchRequestBody body);
}
