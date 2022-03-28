package jSearch.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class JobPosition {
    UUID position_id;
    String position_title;
    int weekly_hours;
    boolean is_filled;
    int salary;
    UUID company_id;

    public JobPosition(UUID position_id, String position_title, int weekly_hours, boolean is_filled, int salary) {
        this.position_id = position_id;
        this.position_title = position_title;
        this.weekly_hours = weekly_hours;
        this.is_filled = is_filled;
        this.salary = salary;
    }

    public JobPosition(String company_id, String position_title, int salary) {
        this.company_id = UUID.fromString(company_id);
        this.position_title = position_title;
        this.salary = salary;
    }
}
