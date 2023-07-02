package com.example.jobsearch.repository;

import com.example.jobsearch.entity.job.JobDAO;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<JobDAO, Integer> {
}
