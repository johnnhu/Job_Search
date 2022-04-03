package jSearch.models;

import java.util.UUID;

public class Applicant {
    public UUID applicant_id;
    public String applicant_name;
    public String applicant_phone;
    public String applicant_email;
    public UUID spec_id;
    public UUID supervisor_id;
    public String university_name;

    public Applicant(UUID applicant_id, String applicant_name, String applicant_phone, String applicant_email, UUID spec_id, UUID supervisor_id, String university_name) {
        this.applicant_id = applicant_id;
        this.applicant_name = applicant_name;
        this.applicant_phone = applicant_phone;
        this.applicant_email = applicant_email;
        this.spec_id = spec_id;
        this.supervisor_id = supervisor_id;
        this.university_name = university_name;
    }
}
