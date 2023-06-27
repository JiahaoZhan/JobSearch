package com.example.jobsearch.service.job;

import com.example.jobsearch.entity.job.Job;
import com.example.jobsearch.service.serpAPI.SearchRequestBody;
import com.example.jobsearch.service.serpAPI.SerpSearchParam;

import java.util.List;


public interface JobService {

    //This search will query the serp api
    public String search(SearchRequestBody body);
}
