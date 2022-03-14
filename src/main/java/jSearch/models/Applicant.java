package jSearch.models;

import java.util.UUID;

public class Applicant {
    UUID applicant_id;
    String applicant_name;
    String applicant_phone;
    String applicant_email;

    public Applicant(UUID applicant_id, String applicant_name, String applicant_phone, String applicant_email) {
        this.applicant_id = applicant_id;
        this.applicant_name = applicant_name;
        this.applicant_phone = applicant_phone;
        this.applicant_email = applicant_email;
    }
}
