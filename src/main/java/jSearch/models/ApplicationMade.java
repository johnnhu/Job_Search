package jSearch.models;

import java.util.Date;
import java.util.UUID;

public class ApplicationMade {
    UUID application_id;
    Enum status;
    int resume_version;
    int cover_letter_version;
    Date date_of_application;
    UUID applicant_id;
    UUID position_id;

    public ApplicationMade(UUID application_id, Enum status, int resume_version, int cover_letter_version) {
        this.application_id = application_id;
        this.status = status;
        this.resume_version = resume_version;
        this.cover_letter_version = cover_letter_version;
    }

    public ApplicationMade(UUID application_id, Enum status, int resume_version, int cover_letter_version, Date date_of_application, UUID applicant_id, UUID position_id) {
        this.application_id = application_id;
        this.status = status;
        this.resume_version = resume_version;
        this.cover_letter_version = cover_letter_version;
        this.date_of_application = date_of_application;
        this.applicant_id = applicant_id;
        this.position_id = position_id;
    }
}
