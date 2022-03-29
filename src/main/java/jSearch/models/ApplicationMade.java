package jSearch.models;

import java.sql.Date;
import java.util.UUID;

public class ApplicationMade {
    UUID application_id;
    Enum status_description;
    int resume_version;
    int cover_letter_version;
    Date date_of_application;
    UUID applicant_id;
    UUID position_id;

    public ApplicationMade(UUID application_id, Enum status_description, int resume_version, int cover_letter_version, Date date_of_application, UUID applicant_id, UUID position_id) {
        this.application_id = application_id;
        this.status_description = status_description;
        this.resume_version = resume_version;
        this.cover_letter_version = cover_letter_version;
        this.date_of_application = date_of_application;
        this.applicant_id = applicant_id;
        this.position_id = position_id;
    }
}
