package jSearch.models;

import java.util.UUID;

public class Attends {
    public UUID applicant_id;
    public String university_name;
    public int since_year;
    public int graduation_year;

    public Attends(UUID applicant_id, String university_name, int since_year, int graduation_year) {
        this.applicant_id = applicant_id;
        this.university_name = university_name;
        this.since_year = since_year;
        this.graduation_year = graduation_year;
    }
}
