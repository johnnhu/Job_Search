package jSearch.models;

import java.util.UUID;

public class Application {
    UUID application_id;
    Enum status;
    int resume_version;
    int cover_letter_version;

    public Application(UUID application_id, Enum status, int resume_version, int cover_letter_version) {
        this.application_id = application_id;
        this.status = status;
        this.resume_version = resume_version;
        this.cover_letter_version = cover_letter_version;
    }
}
