package jSearch.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ApplicationMade {
    public UUID application_id;
    public Status status_description;
    public int resume_version;
    public int cover_letter_version;
    public Date date_of_application;
    public UUID applicant_id;
    public UUID position_id;

    public ApplicationMade(UUID application_id, Status status, int resume_version, int cover_letter_version) {
        this.application_id = application_id;
        this.status_description = status;
        this.resume_version = resume_version;
        this.cover_letter_version = cover_letter_version;
    }

    public ApplicationMade(UUID application_id, Status status, int resume_version, int cover_letter_version, Date date_of_application, UUID applicant_id, UUID position_id) {
        this.application_id = application_id;
        this.status_description = status;
        this.resume_version = resume_version;
        this.cover_letter_version = cover_letter_version;
        this.date_of_application = date_of_application;
        this.applicant_id = applicant_id;
        this.position_id = position_id;
    }

    public ApplicationMade(Status status, int resume, int cover, Date date, UUID applicant, UUID position) {
        this.status_description = status;
        this.resume_version = resume;
        this.cover_letter_version = cover;
        this.date_of_application = date;
        this.applicant_id = applicant;
        this.position_id = position;
    }
}
