package com.example.jobsearch.rest;

import com.example.jobsearch.entity.job.Job;
import com.example.jobsearch.service.JobServiceImpl;
import com.example.jobsearch.service.SearchRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobRestController {

    private JobServiceImpl jobService;

    @Autowired
    public JobRestController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public List<Job> search (@RequestBody SearchRequestBody body) {

        return jobService.search(body);
    }

}
