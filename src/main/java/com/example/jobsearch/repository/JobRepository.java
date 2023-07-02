package com.example.jobsearch.repository;

import com.example.jobsearch.entity.job.JobDAO;
import com.example.jobsearch.entity.user.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface JobRepository extends JpaRepository<JobDAO, Long>, JpaSpecificationExecutor<JobDAO> {
    List<JobDAO> findByUser(final UserDAO user);
}
