package com.example.jobsearch.rest;


import com.example.jobsearch.service.job.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserRestController {

    private JobServiceImpl jobService;


    @Autowired
    public UserRestController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/{userId}/marked")
    ResponseEntity<?> markJobs() {

        return ResponseEntity.ok(null);
    }

    @GetMapping("/{userId}/marked")
    ResponseEntity<?> getMarkedJobs() {
        return ResponseEntity.ok(null);
    }
}
