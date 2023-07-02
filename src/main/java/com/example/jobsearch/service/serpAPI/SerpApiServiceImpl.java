package com.example.jobsearch.service.serpAPI;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import serpapi.SerpApiSearchException;


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
