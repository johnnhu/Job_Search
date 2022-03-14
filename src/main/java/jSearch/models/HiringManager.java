package jSearch.models;

import java.util.Date;
import java.util.UUID;

public class HiringManager {
    UUID emp_id;
    Date year_hired;
    String first_name;
    String last_name;

    public HiringManager(UUID emp_id, Date year_hired, String first_name, String last_name) {
        this.emp_id = emp_id;
        this.year_hired = year_hired;
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
