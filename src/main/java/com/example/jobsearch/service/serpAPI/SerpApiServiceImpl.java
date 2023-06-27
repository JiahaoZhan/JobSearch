package com.example.jobsearch.service.serpAPI;

import com.example.jobsearch.entity.job.Job;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import serpapi.SerpApiSearchException;

import java.util.Arrays;
import java.util.List;

@Service
public class SerpApiServiceImpl implements SerpAPIService {

    public String search(SerpSearchParam params) {
        SerpAPIClient client = new SerpAPIClient(params.getParameters(), "google_jobs");
        try
        {
            JsonObject results = client.getJson();
            return results.toString();

        }
        catch (SerpApiSearchException ex) {

        }
        return null;
    }
}
