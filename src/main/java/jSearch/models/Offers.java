package jSearch.models;

import java.util.UUID;

public class Offers {
    String university_name;
    UUID spec_id;

    public Offers(String university_name, UUID spec_id) {
        this.university_name = university_name;
        this.spec_id = spec_id;
    }
}
