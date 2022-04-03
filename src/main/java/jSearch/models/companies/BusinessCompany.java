package jSearch.models.companies;

import jSearch.models.Company;

import java.util.UUID;

public class BusinessCompany extends Company {
    public String field_of_business;
    public String deliverable;

    public BusinessCompany(UUID company_id, String company_name, int num_employees) {
        super(company_id, company_name, num_employees);
    }

    public BusinessCompany(UUID company_id, String company_name, int num_employees, String field_of_business, String deliverable) {
        super(company_id, company_name, num_employees);
        this.field_of_business = field_of_business;
        this.deliverable = deliverable;
    }
}
