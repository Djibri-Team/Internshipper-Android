package com.debeliya_i_kompaniya.internshipper.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;

public class Offer implements Parcelable {
    private int id;
    private String title;
    private String company;
    private String duration;
    private String workingHours;
    private String description;
    private JobCategory type;

    public Offer() {}

    public Offer(int id, String title, String company, String duration, String workingHours, String description, JobCategory type) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    protected Offer(Parcel in) {
        id = in.readInt();
        title = in.readString();
        company = in.readString();
        duration = in.readString();
        workingHours = in.readString();
        description = in.readString();
        type = (JobCategory) in.readValue(JobCategory.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(company);
        dest.writeString(duration);
        dest.writeString(workingHours);
        dest.writeString(description);
        dest.writeValue(type);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Offer> CREATOR = new Parcelable.Creator<Offer>() {
        @Override
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }

        @Override
        public Offer[] newArray(int size) {
            return new Offer[size];
        }
    };
}