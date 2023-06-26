package com.example.jobsearch.entity.job.fields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true) //indicates other fields can be safely ignored
@JsonInclude(JsonInclude.Include.NON_NULL) //indicates null field can be skipped and not included
public class Category {
    private String tag;
    private String label;

    public Category(String label) {
        this.label = label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
