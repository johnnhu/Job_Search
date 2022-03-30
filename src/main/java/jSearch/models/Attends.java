package jSearch.models;

import java.util.UUID;

public class Attends {
    UUID applicant_id;
    String university_name;
    int since_year;
    int graduation_year;

    public Attends(UUID applicant_id, String university_name, int since_year, int graduation_year) {
        this.applicant_id = applicant_id;
        this.university_name = university_name;
        this.since_year = since_year;
        this.graduation_year = graduation_year;
    }
}
