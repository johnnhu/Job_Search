package jSearch.models;

import java.util.UUID;

public class SpecializationInfo {
    public UUID spec_id;
    public String major;
    public String minor;
    public boolean is_honours;
    public String degree_type;

    public SpecializationInfo(UUID spec_id, String major, String minor, boolean is_honours, String degree_type) {
        this.spec_id = spec_id;
        this.major = major;
        this.minor = minor;
        this.is_honours = is_honours;
        this.degree_type = degree_type;
    }

    public SpecializationInfo(String major, String minor, boolean is_honours, String degree_type) {
        this.major = major;
        this.minor = minor;
        this.is_honours = is_honours;
        this.degree_type = degree_type;
    }
}
