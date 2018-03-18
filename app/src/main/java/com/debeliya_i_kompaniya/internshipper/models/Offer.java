package com.debeliya_i_kompaniya.internshipper.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;

public class Offer implements Parcelable {
    private int id;
    private String title;
    private String companyName;
    private String internTimeLength;
    private int workingHours;
    private String description;
    private JobCategory type;
    private int publisherId;

    public Offer() {}

    public Offer(int id, String title, String company, String duration, int workingHours, String description, JobCategory type, int publisherId) {
        this.id = id;
        this.title = title;
        this.companyName = company;
        this.internTimeLength = duration;
        this.workingHours = workingHours;
        this.description = description;
        this.type = type;
        this.publisherId = publisherId;
    }
    public Offer(String title, String company, String duration, int workingHours, String description, JobCategory type, int publisherId) {
        this.title = title;
        this.companyName = company;
        this.internTimeLength = duration;
        this.workingHours = workingHours;
        this.description = description;
        this.type = type;
        this.publisherId = publisherId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getInternTimeLength() {
        return internTimeLength;
    }

    public String getDescription() {
        return description;
    }

    public JobCategory getType() {
        return type;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public int getId() {
        return id;
    }

    public int getPublisherId() {
        return publisherId;
    }

    protected Offer(Parcel in) {
        id = in.readInt();
        title = in.readString();
        companyName = in.readString();
        internTimeLength = in.readString();
        workingHours = in.readInt();
        description = in.readString();
        publisherId = in.readInt();
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
        dest.writeString(companyName);
        dest.writeString(internTimeLength);
        dest.writeInt(workingHours);
        dest.writeString(description);
        dest.writeValue(type);
        dest.writeInt(publisherId);
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

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", internTimeLength='" + internTimeLength + '\'' +
                ", workingHours=" + workingHours +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", publisherId=" + publisherId +
                '}';
    }
}