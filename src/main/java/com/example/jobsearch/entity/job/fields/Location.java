package com.example.jobsearch.entity.job.fields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //indicates other fields can be safely ignored
@JsonInclude(JsonInclude.Include.NON_NULL) //indicates null field can be skipped and not included
public class Location {
    private List<String> area;
    private String display_name;

    public Location(String location) {
        this.display_name = location;
    }

    public List<String> getArea() {
        return area;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
}
