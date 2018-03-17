package com.debeliya_i_kompaniya.internshipper.enums;

/**
 * Created by Stoyan-Ivanov on 17.3.2018 г..
 */

public enum Status {
    PENDING,
    ACCEPTED,
    REJECTED;

    public static Status StringToStatus(String status) {
        switch (status) {
            case "PENDING": return PENDING;
            case "ACCEPTED": return ACCEPTED;
            case "REJECTED": return REJECTED;
            default: return null;
        }
    }
}
