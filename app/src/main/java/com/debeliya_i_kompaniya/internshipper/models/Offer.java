package com.debeliya_i_kompaniya.internshipper.models;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class Offer {
    private String title;
    private String company;
    private int duration;
    private String description;

    public Offer() {}

    public Offer(String title, String company, int duration, String description) {
        this.title = title;
        this.company = company;
        this.duration = duration;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}
