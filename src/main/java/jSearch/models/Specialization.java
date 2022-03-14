package jSearch.models;

import java.util.UUID;

public class Specialization {
    UUID spec_id;
    String major;
    String minor;
    int num_credits;
    boolean is_honours;
    String degree_type;

    // constructor for all fields that cannot be NULL
    // TODO: add checks in models for not null
    // TODO: add methods in models to get functional dependencies (e.g. given major, is_honours, degree_type, get numCredits?)
    public Specialization(UUID spec_id, String major, int num_credits, boolean is_honours, String degree_type) {
        this.spec_id = spec_id;
        this.major = major;
        this.num_credits = num_credits;
        this.is_honours = is_honours;
        this.degree_type = degree_type;
    }

    public Specialization(UUID spec_id, String major, String minor, int num_credits, boolean is_honours, String degree_type) {
        this.spec_id = spec_id;
        this.major = major;
        this.minor = minor;
        this.num_credits = num_credits;
        this.is_honours = is_honours;
        this.degree_type = degree_type;
    }
}
