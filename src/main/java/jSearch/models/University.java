package jSearch.models;

import java.util.Date;

public class University {
    String university_name;
    int year_established;
    String region;
    String country;

    public University(String university_name, int year_established, String region, String country) {
        this.university_name = university_name;
        this.year_established = year_established;
        this.region = region;
        this.country = country;
    }
}
