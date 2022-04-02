package jSearch.models;

import java.util.UUID;

public class SpecializationCredits {
    public UUID spec_id;
    public String major;
    public int num_credits;
    public boolean is_honours;
    public String degree_type;

    // constructor for all fields that cannot be NULL
    // TODO: add checks in models for not null
    // TODO: add methods in models to get functional dependencies (e.g. given major, is_honours, degree_type, get numCredits?)
    public SpecializationCredits(UUID spec_id, String major, int num_credits, boolean is_honours, String degree_type) {
        this.spec_id = spec_id;
        this.major = major;
        this.num_credits = num_credits;
        this.is_honours = is_honours;
        this.degree_type = degree_type;
    }
}
