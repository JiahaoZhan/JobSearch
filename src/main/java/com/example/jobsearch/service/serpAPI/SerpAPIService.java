package com.example.jobsearch.service.serpAPI;

import com.example.jobsearch.entity.job.Job;

import java.util.List;

public interface SerpAPIService {
    public String search(SerpSearchParam params);

}
