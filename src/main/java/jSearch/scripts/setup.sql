CREATE TABLE specialization_credits(
    major varchar(60) not null,
    is_honours boolean not null,
    degree_type varchar(60) not null,
    num_credits integer not null,
    PRIMARY KEY(major, is_honours, degree_type)
);
INSERT INTO specialization_credits(major, is_honours, degree_type, num_credits) VALUES ('Computer Science', True, 'BSc', 132);

CREATE TABLE specialization_info(
    spec_id UUID not null PRIMARY KEY,
    major varchar(60) not null,
    minor varchar(60) not null,
    is_honours boolean not null,
    degree_type varchar(60) not null
);
INSERT INTO specialization_info(spec_id, major, minor, is_honours, degree_type) VALUES ('9660b94a-9b49-11ec-b909-0242ac120002', 'Computer Science', 'Statistics', True, 'BSc');

CREATE TABLE offers(
    university_name varchar(60),
    spec_id UUID,
    PRIMARY KEY(university_name, spec_id),
    FOREIGN KEY (university_name) REFERENCES university,
    FOREIGN KEY (spec_id) REFERENCES specialization_info
);
INSERT INTO offers(university_name, spec_id) VALUES ('University of British Columbia', '9660b94a-9b49-11ec-b909-0242ac120002');

CREATE TABLE university(
    university_name varchar(60) PRIMARY KEY,
    region varchar(60),
    year_established date,
    country varchar(60)
);
INSERT INTO university(university_name, region, year_established, country) VALUES ('University of British Columbia', 'British Columbia', 1908, 'Canada');

CREATE TABLE coop_supervisor_works_at(
    supervisor_id UUID PRIMARY KEY,
    supervisor_name varchar(60),
    supervisor_phone varchar(60) UNIQUE,
    supervisor_email varchar(60) UNIQUE,
    capacity integer,
    worked_since date NOT NULL,
    university_name varchar(60) NOT NULL,
    FOREIGN KEY(university_name) REFERENCES university
);
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('f05456ee-9b4b-11ec-b909-0242ac120002', 'Lexine Atrill', '604-822-9289', 'lexine.atrill@ubc.ca', 50, 2015, 'University of British Columbia');

CREATE TABLE applicant(
    applicant_id UUID PRIMARY KEY,
    applicant_name varchar(60),
    applicant_phone varchar(60) UNIQUE,
    applicant_email varchar(60) UNIQUE,
    spec_id UUID NOT NULL,
    supervisor_id UUID NOT NULL,
    FOREIGN KEY(spec_id) REFERENCES specialization_info,
    FOREIGN KEY(supervisor_id) REFERENCES coop_supervisor_works_at
);
INSERT INTO applicant(applicant_id, applicant_name, applicant_phone, applicant_email, spec_id, supervisor_id) VALUES ('530ab1f6-9b4d-11ec-b909-0242ac120002', 'Michael DeMarco', '720-586-5172', 'michael.demarco@gmail.com', '9660b94a-9b49-11ec-b909-0242ac120002', 'f05456ee-9b4b-11ec-b909-0242ac120002', 'University of British Columbia');

CREATE TABLE application_made(
    applicant_id UUID PRIMARY KEY,
    status enum('Not Started', 'In Progress', 'Submitted', 'Offered Interview', 'Under Review', 'Offered Position', 'Rejected'),
    resume_version integer,
    cover_letter_version integer,
    date_of_application date,
    applicant_id UUID NOT NULL,
    position_id UUID NOT NULL,
    FOREIGN KEY(applicant_id) REFERENCES applicant,
    FOREIGN KEY(position_id) REFERENCES job_position_belongs_to
);
INSERT INTO application_made(application_id, status, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('403925c0-9b4e-11ec-b909-0242ac120002', 'Not Started', 5, 1, 2022-01-03, '530ab1f6-9b4d-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');

CREATE TABLE attends(
    applicant_id UUID,
    university_name varchar(60),
    since date NOT NULL,
    graduation_date date,
    PRIMARY KEY (applicant_id, university_name),
    FOREIGN KEY(applicant_id) REFERENCES applicant,
    FOREIGN KEY(university_name) REFERENCES university
);
INSERT INTO attends(applicant_id, university_name, since, graduation_date) VALUES ('530ab1f6-9b4d-11ec-b909-0242ac120002', 'University of British Columbia', 2019, 2026);


CREATE TABLE lives_at_address(
    street_address varchar(60),
    city varchar(60),
    postal_code varchar(10),
    region varchar(60),
    country varchar(60),
    applicant_id UUID,
    PRIMARY KEY (street_address, applicant_id),
    FOREIGN KEY (applicant_id) REFERENCES applicant ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO lives_at_address(street_address, city, postal_code, region, country, applicant_id) VALUES ('217 Shipley St.', 'Ottawa', 'T5A 6C8', 'Ontario', 'Canada', '530ab1f6-9b4d-11ec-b909-0242ac120002');

CREATE TABLE job_position_belongs_to(
    position_id UUID PRIMARY KEY,
    position_title varchar(60) NOT NULL,
    is_filled boolean,
    company_id UUID NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO job_position_belongs_to(position_id, position_title, is_filled, company_id) VALUES ('468516d2-9b4e-11ec-b909-0242ac120002', 'Software Engineer Intern', TRUE, '2f12f85e-9b51-11ec-b909-0242ac120002');

CREATE TABLE job_position_compensation(
    position_title varchar(60) NOT NULL,
    company_id UUID NOT NULL,
    weekly_hours integer NOT NULL,
    salary integer NOT NULL,
    PRIMARY KEY (position_title, company_id),
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO job_position_compensation(position_title, company_id, weekly_hours, salary) VALUES ('Software Engineer Intern', '2f12f85e-9b51-11ec-b909-0242ac120002', 40, 6000);

CREATE TABLE company(
    company_id UUID NOT NULL PRIMARY KEY,
    company_name varchar(60) NOT NULL,
    num_employees integer
);
INSERT INTO company(company_id, company_name, num_employees) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'Apple', 2000000);

CREATE TABLE business_company(
    company_id UUID NOT NULL PRIMARY KEY,
    field_of_business varchar(60) NOT NULL,
    deliverable varchar(60),
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO business_company(company_id, field_of_business, deliverable) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'marketing', 'marketing campaign');

CREATE TABLE technology_company(
    company_id UUID NOT NULL PRIMARY KEY,
    tech_stack varchar(60),
    product varchar(60) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO technology_company(company_id, tech_stack, product) VALUES ('9d5f5c4c-9b53-11ec-b909-0242ac120002', 'assembly', 'cell phone');

CREATE TABLE healthcare_company(
    company_id UUID NOT NULL PRIMARY KEY,
    specialty varchar(60) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO healthcare_company(specialty, company_id) VALUES ('9b7bf24a-9b63-11ec-b909-0242ac120002', 'oncology');

CREATE TABLE prefers(
    company_id UUID,
    university_name varchar(60),
    PRIMARY KEY(company_id, university_name),
    FOREIGN KEY (company_id) REFERENCES company,
    FOREIGN KEY (university_name) REFERENCES university
);
INSERT INTO prefers(company_id, university_name) VALUES ('9b7bf24a-9b63-11ec-b909-0242ac120002', 'University of British Columbia');

CREATE TABLE hiring_manager_works_for(
    emp_id UUID PRIMARY KEY,
    year_hired date NOT NULL,
    first_name varchar(60) NOT NULL,
    last_name varchar(60) NOT NULL,
    company_id UUID NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);

INSERT INTO hiring_manager_works_for(employee_id, year_hired, first_name, last_name, company_id) VALUES ('f1cdb412-9b63-11ec-b909-0242ac120002', 2015, 'Meghan', 'Allen', '9660b94a-9b49-11ec-b909-0242ac120002');

CREATE TABLE manages(
    position_id UUID,
    emp_id UUID,
    PRIMARY KEY(position_id, emp_id),
    FOREIGN KEY (position_id) REFERENCES job_position_belongs_to,
    FOREIGN KEY (emp_id) REFERENCES hiring_manager_works_for
);
INSERT INTO manages(position_id, emp_id) VALUES ('468516d2-9b4e-11ec-b909-0242ac120002', 'f1cdb412-9b63-11ec-b909-0242ac120002');

CREATE TABLE requires(
    spec_id UUID,
    position_id UUID,
    PRIMARY KEY(spec_id, position_id),
    FOREIGN KEY (spec_id) REFERENCES specialization_info,
    FOREIGN KEY (position_id) REFERENCES job_position_belongs_to
);
INSERT INTO requires(spec_id, position_id) VALUES ('9660b94a-9b49-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');

CREATE TABLE oversees(
    emp_id UUID,
    applicant_id UUID,
    PRIMARY KEY(emp_id, applicant_id),
    FOREIGN KEY (emp_id) REFERENCES hiring_manager_works_for,
    FOREIGN KEY (applicant_id) REFERENCES applicant
);
INSERT INTO oversees(emp_id, applicant_id) VALUES ('f1cdb412-9b63-11ec-b909-0242ac120002', '530ab1f6-9b4d-11ec-b909-0242ac120002');
