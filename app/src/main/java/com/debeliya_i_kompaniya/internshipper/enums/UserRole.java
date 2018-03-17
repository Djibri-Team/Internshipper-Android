package com.debeliya_i_kompaniya.internshipper.enums;


public enum UserRole {
    STUDENT,
    EMPLOYER;

    public static Status StringToUserRole(String userRole) {
        switch (userRole) {
            case "STUDENT": return STUDENT;
            case "EMPLOYER": return EMPLOYER;
            default: break;
        }
        return;
    }
}
