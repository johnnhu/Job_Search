package jSearch.models;

public class University {
    public String university_name;
    public int year_established;
    public String region;
    public String country;

    public University(String university_name, int year_established, String region, String country) {
        this.university_name = university_name;
        this.year_established = year_established;
        this.region = region;
        this.country = country;
    }
}
