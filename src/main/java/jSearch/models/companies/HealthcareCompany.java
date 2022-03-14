package jSearch.models.companies;

import jSearch.models.Company;

import java.util.UUID;

public class HealthcareCompany extends Company {
    String specialty;

    public HealthcareCompany(UUID company_id, String company_name, int num_employees) {
        super(company_id, company_name, num_employees);
    }

    public HealthcareCompany(UUID company_id, String company_name, int num_employees, String specialty) {
        super(company_id, company_name, num_employees);
        this.specialty = specialty;
    }
}
