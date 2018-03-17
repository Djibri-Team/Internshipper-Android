package com.debeliya_i_kompaniya.internshipper.models;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;

public class Offer {
    private String title;
    private String company;
    private String duration;
    private String workingHours;
    private String description;
    private JobCategory type;

    public Offer() {}

    public Offer(String title, String company, String duration, String workingHours, String description, JobCategory type) {
        this.title = title;
        this.company = company;
        this.duration = duration;
        this.workingHours = workingHours;
        this.description = description;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public JobCategory getType() {
        return type;
    }

    public String getWorkingHours() {
        return workingHours;
    }
}
