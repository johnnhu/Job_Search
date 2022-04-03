package jSearch.models;

import java.util.UUID;

public class Company {
    public UUID company_id;
    public String company_name;
    public int num_employees;

    public Company(UUID company_id, String company_name, int num_employees) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.num_employees = num_employees;
    }
}
