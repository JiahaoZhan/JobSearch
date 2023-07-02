package com.example.jobsearch.service.job;

import com.example.jobsearch.entity.job.JobDAO;
import com.example.jobsearch.entity.job.JobDTO;
import com.example.jobsearch.entity.user.UserDAO;
import com.example.jobsearch.service.serpAPI.SearchRequestBody;

import java.util.List;

public interface JobService {
    //This search will query the serp api
    public String search(SearchRequestBody body);

    public JobDAO save(JobDTO job, UserDAO user);

    public String unsave(JobDTO job, UserDAO user);

    public List<JobDAO> getSaved(UserDAO user);

}
