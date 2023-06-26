package com.example.jobsearch.service;

import com.example.jobsearch.entity.job.Job;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import serpapi.GoogleSearch;
import serpapi.SerpApiSearchException;

import java.util.Arrays;
import java.util.List;

@Service
public class SerpApiServiceImpl implements SerpAPIService {

    public List<Job> search(SerpSearchParam params) {
        GoogleSearch searchJobs = new GoogleSearch(params.getParameters());
        try
        {
            JsonObject results = searchJobs.getJson();
            ObjectMapper mapper = new ObjectMapper();
            List<Job> jobResults = Arrays.asList(mapper.readValue(results.getAsString(), Job[].class));
            return jobResults;
        }
        catch (SerpApiSearchException ex) {

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
