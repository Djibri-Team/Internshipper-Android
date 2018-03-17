package com.debeliya_i_kompaniya.internshipper.enums;


public enum JobCategory {
    SOFTWARE,
    HARDWARE,
    EMBEDDED;

    public static JobCategory StringToJobCategory(String jobCategory) {
        switch (jobCategory) {
            case "SOFTWARE": return SOFTWARE;
            case "HARDWARE": return HARDWARE;
            case "EMBEDDED": return EMBEDDED;
            default: break;
        }
        return null;
    }
}
