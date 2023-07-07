package com.example.jobsearch.service.job;

import com.example.jobsearch.entity.job.JobDAO;
import com.example.jobsearch.entity.job.JobDTO;
import com.example.jobsearch.entity.user.UserDAO;
import com.example.jobsearch.repository.JobRepository;
import com.example.jobsearch.service.redis.RedisService;
import com.example.jobsearch.service.redis.RedisServiceImpl;
import com.example.jobsearch.service.serpAPI.SearchRequestBody;
import com.example.jobsearch.service.serpAPI.SerpAPIService;
import com.example.jobsearch.service.serpAPI.SerpSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private SerpAPIService serpAPIService;

    private RedisService redisService;

    private JobRepository jobRepo;

    private static String SEARCH_KEY_TEMPLATE = "&q=%s&gl=%s&start=%s";

    @Autowired
    public JobServiceImpl(SerpAPIService serpAPIService, RedisService redisService, JobRepository jobRepo) {
        this.serpAPIService = serpAPIService;
        this.redisService = redisService;
        this.jobRepo = jobRepo;
    }

    @Override
    public String search(SearchRequestBody body) {
        // set to Canada temporarily as search by country is not implemented yet.
        // pagination set 0. It means return jobs on the first page of Google job.
        String jobsJson = redisService.getValue(body.getQuery(), "ca", "0");
        if (jobsJson != null) return jobsJson;
        SerpSearchParam params = new SerpSearchParam();
        params.addEngine("google_jobs")
                    .addQuery(body.getQuery())
                    .addCountryCode("ca")
                    .addGoogleDomain("google.ca")
                    .addLanguageCode("en");
        jobsJson = serpAPIService.search(params);
        redisService.setValue(body.getQuery(), "ca", "0", jobsJson);
        return jobsJson;
    }

    @Override
    public JobDAO save(JobDTO job, UserDAO user) {
        JobDAO dbJob = jobRepo.findByJobId(job.getJobId());
        if (dbJob == null) {
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
            savedJob.setJobId(job.getJobId());
            savedJob.setUser(user);
            return jobRepo.save(savedJob);
        }
        return null;
    }

    @Override
    public String unsave(JobDTO job, UserDAO user) {
        JobDAO dbJob = jobRepo.findByJobId(job.getJobId());
        if (dbJob != null) {
            int isDeleted = jobRepo.deleteByJobIdAndUser(job.getJobId(), user);
            if (isDeleted > 0) return dbJob.getJobId();
            else return null;
        }
        return null;
    }

    @Override
    public List<JobDAO> getSaved(UserDAO user) {
        List<JobDAO> jobs = jobRepo.findByUser(user);
        return jobs;
    }
}
