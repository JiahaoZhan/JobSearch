package com.example.jobsearch.service;

public class SearchRequestBody {
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private String query;
}