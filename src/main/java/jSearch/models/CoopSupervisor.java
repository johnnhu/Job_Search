package jSearch.models;

import java.util.UUID;

public class CoopSupervisor {
    UUID supervisor_id;
    String supervisor_name;
    String supervisor_phone;
    String supervisor_email;
    int capacity;

    public CoopSupervisor(UUID supervisor_id, String supervisor_name, String supervisor_phone, String supervisor_email, int capacity) {
        this.supervisor_id = supervisor_id;
        this.supervisor_name = supervisor_name;
        this.supervisor_phone = supervisor_phone;
        this.supervisor_email = supervisor_email;
        this.capacity = capacity;
    }
}
