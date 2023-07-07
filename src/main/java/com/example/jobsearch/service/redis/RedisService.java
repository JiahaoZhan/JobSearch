package com.example.jobsearch.service.redis;


public interface RedisService {

    public void setValue(String query, String country, String start, String searchResult);

    public String getValue(String query, String country, String start);
}
