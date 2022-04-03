package jSearch.models.companies;

import jSearch.models.Company;

import java.util.UUID;

public class TechCompany extends Company {
    public String tech_stack;
    public String product;

    public TechCompany(UUID company_id, String company_name, int num_employees) {
        super(company_id, company_name, num_employees);
    }

    public TechCompany(UUID company_id, String company_name, int num_employees, String tech_stack, String product) {
        super(company_id, company_name, num_employees);
        this.tech_stack = tech_stack;
        this.product = product;
    }
}
