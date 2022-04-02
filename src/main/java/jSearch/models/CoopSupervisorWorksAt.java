package jSearch.models;

import java.util.UUID;

public class CoopSupervisorWorksAt {
    public UUID supervisor_id;
    public String supervisor_name;
    public String supervisor_phone;
    public String supervisor_email;
    public int capacity;
    public int worked_since;
    public String university_name;

    public CoopSupervisorWorksAt(UUID supervisor_id, String supervisor_name, String supervisor_phone, String supervisor_email, int capacity, int worked_since, String university_name) {
        this.supervisor_id = supervisor_id;
        this.supervisor_name = supervisor_name;
        this.supervisor_phone = supervisor_phone;
        this.supervisor_email = supervisor_email;
        this.capacity = capacity;
        this.worked_since = worked_since;
        this.university_name = university_name;
    }
}
