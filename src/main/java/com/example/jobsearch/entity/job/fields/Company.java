package com.example.jobsearch.entity.job.fields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true) //indicates other fields can be safely ignored
@JsonInclude(JsonInclude.Include.NON_NULL) //indicates null field can be skipped and not included
public class Company {
     String display_name;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
}
