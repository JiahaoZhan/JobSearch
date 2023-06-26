package com.example.jobsearch.entity.job;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="jobs")
public class Job {

    public Job() {

    }

    public Job(String id, String title, String location, String salary_min, String latitude, String longitude, String company, String salary_is_predicted, String redirect_url, String contract_time, String salary_max, String description, String created, String category) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.salary_min = salary_min;
        this.latitude = latitude;
        this.longitude = longitude;
        this.company = company;
        this.salary_is_predicted = salary_is_predicted;
        this.redirect_url = redirect_url;
        this.contract_time = contract_time;
        this.salary_max = salary_max;
        this.description = description;
        this.created = created;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", salary_min='" + salary_min + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", company='" + company + '\'' +
                ", salary_is_predicted='" + salary_is_predicted + '\'' +
                ", redirect_url='" + redirect_url + '\'' +
                ", contract_time='" + contract_time + '\'' +
                ", salary_max='" + salary_max + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "location")
    private String location;

    @Column(name = "salary_min")
    private String salary_min;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "company")
    private String company;

    @Column(name = "salary_is_predicted")
    private String salary_is_predicted;

    @Column(name = "redirect_url")
    private String redirect_url;

    @Column(name = "contract_time")
    private String contract_time;

    @Column(name = "salary_max")
    private String salary_max;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private String created;

    @Column(name = "category")
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(String salary_min) {
        this.salary_min = salary_min;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary_is_predicted() {
        return salary_is_predicted;
    }

    public void setSalary_is_predicted(String salary_is_predicted) {
        this.salary_is_predicted = salary_is_predicted;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getContract_time() {
        return contract_time;
    }

    public void setContract_time(String contract_time) {
        this.contract_time = contract_time;
    }

    public String getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(String salary_max) {
        this.salary_max = salary_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
