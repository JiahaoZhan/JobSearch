package com.example.jobsearch.service.job;

import com.example.jobsearch.entity.job.Job;
import com.example.jobsearch.service.serpAPI.SearchRequestBody;
import com.example.jobsearch.service.serpAPI.SerpAPIService;
import com.example.jobsearch.service.serpAPI.SerpSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private SerpAPIService serpAPIService;

    @Autowired
    public JobServiceImpl(SerpAPIService serpAPIService) {
        this.serpAPIService = serpAPIService;
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

}
