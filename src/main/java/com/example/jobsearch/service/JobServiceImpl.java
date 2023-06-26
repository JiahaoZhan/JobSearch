package com.example.jobsearch.service;

import com.example.jobsearch.dao.JobDAO;
import com.example.jobsearch.entity.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobDAO jobDAO;
    private SerpAPIService serpService;

    @Autowired
    public JobServiceImpl(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
        this.serpService = new SerpApiServiceImpl();
    }

    @Override
    public List<Job> findAll() {
        return jobDAO.findAll();
    }

    @Override
    public List<Job> search(SearchRequestBody body) {
        SerpSearchParam params = new SerpSearchParam();
        params.populateAPIParam(body);
        List<Job> jobs = this.serpService.search(params);
        return jobs;
    }
}
