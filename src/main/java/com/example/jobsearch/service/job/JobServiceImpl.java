package com.example.jobsearch.service.job;

import com.example.jobsearch.entity.job.JobDAO;
import com.example.jobsearch.entity.job.JobDTO;
import com.example.jobsearch.entity.user.UserDAO;
import com.example.jobsearch.repository.JobRepository;
import com.example.jobsearch.service.serpAPI.SearchRequestBody;
import com.example.jobsearch.service.serpAPI.SerpAPIService;
import com.example.jobsearch.service.serpAPI.SerpSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private SerpAPIService serpAPIService;

    private JobRepository jobRepo;


    @Autowired
    public JobServiceImpl(SerpAPIService serpAPIService, JobRepository jobRepo) {
        this.serpAPIService = serpAPIService;
        this.jobRepo = jobRepo;
    }

    @Override
    public String search(SearchRequestBody body) {
        SerpSearchParam params = new SerpSearchParam();
        params.addEngine("google_jobs")
                .addQuery(body.getQuery())
                .addCountryCode("ca")
                .addGoogleDomain("google.ca")
                .addLanguageCode("en");
        String jobsJson = serpAPIService.search(params);
        return jobsJson;
    }

    @Override
    public JobDAO save(JobDTO job, UserDAO user) {
        JobDAO savedJob = new JobDAO();
        savedJob.setTitle(job.getTitle());
        savedJob.setCompanyName(job.getCompanyName());
        savedJob.setLocation(job.getLocation());
        savedJob.setVia(job.getVia());
        savedJob.setDescription(job.getDescription());
        savedJob.setQualifications(job.getQualifications());
        savedJob.setBenefits(job.getBenefits());
        savedJob.setResponsibilities(job.getResponsibilities());
        savedJob.setRelatedLink(job.getRelatedLink());
        savedJob.setLinkTitle(job.getLinkTitle());
        savedJob.setPostedAt(job.getPostedAt());
        savedJob.setScheduleType(job.getScheduleType());
        savedJob.setThumbnail(job.getThumbnail());
        savedJob.setUser(user);
        return jobRepo.save(savedJob);
    }
}
