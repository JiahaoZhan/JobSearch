package com.example.jobsearch.service;

import com.example.jobsearch.entity.job.Job;

import java.util.List;

public interface SerpAPIService {
    public List<Job> search(SerpSearchParam params);

}
