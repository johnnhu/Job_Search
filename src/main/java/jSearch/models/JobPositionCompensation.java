package jSearch.models;

import java.util.UUID;

public class JobPositionCompensation {
    String position_title;
    UUID company_id;
    int weekly_hours;
    int salary;

    public JobPositionCompensation(String position_title, UUID company_id, int weekly_hours, int salary) {
        this.position_title = position_title;
        this.company_id = company_id;
        this.weekly_hours = weekly_hours;
        this.salary = salary;
    }

    public JobPositionCompensation(UUID company_id, String position_title, int salary) {
        this.company_id = company_id;
        this.position_title = position_title;
        this.salary = salary;
    }

    public JobPositionCompensation(String position_title, int salary) {
        this.position_title = position_title;
        this.salary = salary;
    }
}
