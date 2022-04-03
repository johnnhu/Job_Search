package jSearch.models;

import java.util.UUID;

public class SpecializationCredits {
    public UUID spec_id;
    public String major;
    public int num_credits;
    public boolean is_honours;
    public String degree_type;

    public SpecializationCredits(UUID spec_id, String major, int num_credits, boolean is_honours, String degree_type) {
        this.spec_id = spec_id;
        this.major = major;
        this.num_credits = num_credits;
        this.is_honours = is_honours;
        this.degree_type = degree_type;
    }
}
