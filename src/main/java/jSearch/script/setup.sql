drop table if exists company CASCADE;
CREATE TABLE company(
    company_id UUID NOT NULL PRIMARY KEY,
    company_name varchar(60) NOT NULL,
    num_employees integer
);
INSERT INTO company(company_id, company_name, num_employees) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'Apple', 2000000);
INSERT INTO company(company_id, company_name, num_employees) VALUES ('2f12fade-9b51-11ec-b909-0242ac120002', 'Microsoft', 50000);
INSERT INTO company(company_id, company_name, num_employees) VALUES ('2f12fc3c-9b51-11ec-b909-0242ac120002', 'KPMG', 3256);
INSERT INTO company(company_id, company_name, num_employees) VALUES ('2f12ff34-9b51-11ec-b909-0242ac120002', 'Google', 43546);
INSERT INTO company(company_id, company_name, num_employees) VALUES ('2f1301aa-9b51-11ec-b909-0242ac120002', 'StartupCo', 30);

drop table if exists specialization_credits CASCADE;
CREATE TABLE specialization_credits(
    major varchar(60) not null,
    is_honours boolean not null,
    degree_type varchar(60) not null,
    num_credits integer not null,
    PRIMARY KEY(major, is_honours, degree_type)
);
INSERT INTO specialization_credits(major, is_honours, degree_type, num_credits) VALUES ('Computer Science', True, 'BSc', 132);
INSERT INTO specialization_credits(major, is_honours, degree_type, num_credits) VALUES ('Cellular, Anatomical, Physiological Sciences', True, 'BSc', 140);
INSERT INTO specialization_credits(major, is_honours, degree_type, num_credits) VALUES ('Accounting', False, 'BCom', 120);
INSERT INTO specialization_credits(major, is_honours, degree_type, num_credits) VALUES ('Psychology', False, 'BA', 110);
INSERT INTO specialization_credits(major, is_honours, degree_type, num_credits) VALUES ('Integrated Engineering', False, 'BASc', 152);

drop table if exists specialization_info CASCADE;
CREATE TABLE specialization_info(
    spec_id UUID not null PRIMARY KEY,
    major varchar(60) not null,
    minor varchar(60),
    is_honours boolean not null,
    degree_type varchar(60) not null
);
INSERT INTO specialization_info(spec_id, major, minor, is_honours, degree_type) VALUES ('9660b94a-9b49-11ec-b909-0242ac120002', 'Computer Science', 'Statistics', True, 'BSc');
INSERT INTO specialization_info(spec_id, major, minor, is_honours, degree_type) VALUES ('830af072-9b49-11ec-b909-0242ac120002', 'Cellular, Anatomical, Physiological Sciences', null, True, 'BSc');
INSERT INTO specialization_info(spec_id, major, minor, is_honours, degree_type) VALUES ('8704b546-9b49-11ec-b909-0242ac120002', 'Accounting', null, False, 'BCom');
INSERT INTO specialization_info(spec_id, major, minor, is_honours, degree_type) VALUES ('8d955e4c-9b49-11ec-b909-0242ac120002', 'Psychology', 'Geography', False, 'BA');
INSERT INTO specialization_info(spec_id, major, minor, is_honours, degree_type) VALUES ('914da9a4-9b49-11ec-b909-0242ac120002', 'Integrated Engineering', null, False, 'BASc');

drop table if exists university CASCADE;
CREATE TABLE university(
    university_name varchar(60) PRIMARY KEY,
    region varchar(60),
    year_established integer,
    country varchar(60)
);
INSERT INTO university(university_name, region, year_established, country) VALUES ('University of British Columbia', 'British Columbia', 1908, 'Canada');
INSERT INTO university(university_name, region, year_established, country) VALUES ('McMaster University', 'Ontario', 1887, 'Canada');
INSERT INTO university(university_name, region, year_established, country) VALUES ('McGill University', 'Quebec', 1821, 'Canada');
INSERT INTO university(university_name, region, year_established, country) VALUES ('University of Toronto', 'Ontario', 1827, 'Canada');
INSERT INTO university(university_name, region, year_established, country) VALUES ('Queens University', 'Ontario', 1841, 'Canada');

drop table if exists offers CASCADE;
CREATE TABLE offers(
    university_name varchar(60),
    spec_id UUID,
    PRIMARY KEY(university_name, spec_id),
    FOREIGN KEY (university_name) REFERENCES university,
    FOREIGN KEY (spec_id) REFERENCES specialization_info
);
INSERT INTO offers(university_name, spec_id) VALUES ('University of British Columbia', '9660b94a-9b49-11ec-b909-0242ac120002');
INSERT INTO offers(university_name, spec_id) VALUES ('McMaster University', '830af072-9b49-11ec-b909-0242ac120002');
INSERT INTO offers(university_name, spec_id) VALUES ('McGill University', '8704b546-9b49-11ec-b909-0242ac120002');
INSERT INTO offers(university_name, spec_id) VALUES ('University of Toronto', '8d955e4c-9b49-11ec-b909-0242ac120002');
INSERT INTO offers(university_name, spec_id) VALUES ('Queens University', '914da9a4-9b49-11ec-b909-0242ac120002');

drop table if exists coop_supervisor_works_at CASCADE;
CREATE TABLE coop_supervisor_works_at(
    supervisor_id UUID PRIMARY KEY,
    supervisor_name varchar(60),
    supervisor_phone varchar(60) UNIQUE,
    supervisor_email varchar(60) UNIQUE,
    capacity integer,
    worked_since integer NOT NULL,
    university_name varchar(60) NOT NULL,
    FOREIGN KEY(university_name) REFERENCES university
);
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('f05456ee-9b4b-11ec-b909-0242ac120002', 'Lexine Atrill', '604-822-9289', 'lexine.atrill@ubc.ca', 50, 2015, 'University of British Columbia');
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('f3edf06c-9b4b-11ec-b909-0242ac120002', 'Sharon Craddock', '416-822-8087', 'sharon.craddock@mcmaster.ca', 30, 2019, 'McMaster University');
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('f72a636e-9b4b-11ec-b909-0242ac120002', 'Celine Francis', '514-324-5356', 'celine.francis@mcgill.ca', 25, 2017, 'McGill University');
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('fd86c144-9b4b-11ec-b909-0242ac120002', 'Emily Fuchs', '416-822-2481', 'emilyef@uoft.ca', 100, 2020, 'University of Toronto');
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('01d697ba-9b4c-11ec-b909-0242ac120002', 'Lara Hall', '613-543-6547', 'lara.hall@queens.ca', 42, 2011, 'Queens University');
INSERT INTO coop_supervisor_works_at(supervisor_id, supervisor_name, supervisor_phone, supervisor_email, capacity, worked_since, university_name) VALUES ('46851f56-9b4e-11ec-b909-0242ac120002', 'Patrice Belleville', '613-243-6547', 'patrice.belleville@ubc.ca', 42, 2011, 'University of British Columbia');


drop table if exists applicant CASCADE;
CREATE TABLE applicant(
    applicant_id UUID PRIMARY KEY,
    applicant_name varchar(60),
    applicant_phone varchar(60) UNIQUE,
    applicant_email varchar(60) UNIQUE,
    spec_id UUID NOT NULL,
    supervisor_id UUID NOT NULL,
    university_name varchar(60),
    FOREIGN KEY(spec_id) REFERENCES specialization_info,
    FOREIGN KEY(supervisor_id) REFERENCES coop_supervisor_works_at,
    FOREIGN KEY(university_name) REFERENCES university
);
INSERT INTO applicant(applicant_id, applicant_name, applicant_phone, applicant_email, spec_id, supervisor_id, university_name) VALUES ('530ab1f6-9b4d-11ec-b909-0242ac120002', 'Michael DeMarco', '720-586-5172', 'michael.demarco@gmail.com', '9660b94a-9b49-11ec-b909-0242ac120002', 'f05456ee-9b4b-11ec-b909-0242ac120002', 'University of British Columbia');
INSERT INTO applicant(applicant_id, applicant_name, applicant_phone, applicant_email, spec_id, supervisor_id, university_name) VALUES ('530ab732-9b4d-11ec-b909-0242ac120002', 'Emily Chen', '534-726-5725', 'emily.chen@gmail.com', '830af072-9b49-11ec-b909-0242ac120002', 'f3edf06c-9b4b-11ec-b909-0242ac120002', 'McMaster University');
INSERT INTO applicant(applicant_id, applicant_name, applicant_phone, applicant_email, spec_id, supervisor_id, university_name) VALUES ('530ab8a4-9b4d-11ec-b909-0242ac120002', 'Jonathan Hu', '800-201-4779', 'jonathan.hu@hotmail.com', '8704b546-9b49-11ec-b909-0242ac120002', 'f72a636e-9b4b-11ec-b909-0242ac120002', 'McGill University');
INSERT INTO applicant(applicant_id, applicant_name, applicant_phone, applicant_email, spec_id, supervisor_id, university_name) VALUES ('530abc64-9b4d-11ec-b909-0242ac120002', 'Hasan Altaf', '310-402-4648', 'hasan.altaf@yahoo.com', '8d955e4c-9b49-11ec-b909-0242ac120002', 'fd86c144-9b4b-11ec-b909-0242ac120002', 'University of Toronto');
INSERT INTO applicant(applicant_id, applicant_name, applicant_phone, applicant_email, spec_id, supervisor_id, university_name) VALUES ('530abe12-9b4d-11ec-b909-0242ac120002', 'Annie Liu', '793-331-2507', 'annie.liu@gmail.com', '914da9a4-9b49-11ec-b909-0242ac120002', '01d697ba-9b4c-11ec-b909-0242ac120002', 'Queens University');

drop table if exists job_position_belongs_to CASCADE;
CREATE TABLE job_position_belongs_to(
    position_id UUID PRIMARY KEY,
    position_title varchar(60) NOT NULL,
    is_filled boolean,
    company_id UUID NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO job_position_belongs_to(position_id, position_title, is_filled, company_id) VALUES ('468516d2-9b4e-11ec-b909-0242ac120002', 'Software Engineer Intern', True, '2f12f85e-9b51-11ec-b909-0242ac120002');
INSERT INTO job_position_belongs_to(position_id, position_title, is_filled, company_id) VALUES ('46851a24-9b4e-11ec-b909-0242ac120002', 'PM Intern', True, '2f12fade-9b51-11ec-b909-0242ac120002');
INSERT INTO job_position_belongs_to(position_id, position_title, is_filled, company_id) VALUES ('46851be6-9b4e-11ec-b909-0242ac120002', 'Data Science Intern', False, '2f12fc3c-9b51-11ec-b909-0242ac120002');
INSERT INTO job_position_belongs_to(position_id, position_title, is_filled, company_id) VALUES ('46851d9e-9b4e-11ec-b909-0242ac120002', 'Engineering Intern', False, '2f12ff34-9b51-11ec-b909-0242ac120002');
INSERT INTO job_position_belongs_to(position_id, position_title, is_filled, company_id) VALUES ('46851f56-9b4e-11ec-b909-0242ac120002', 'Healthcare Consulting Intern', False, '2f1301aa-9b51-11ec-b909-0242ac120002');

-- EXAMPLES OF STATUSES: ('Not Started', 'In Progress', 'Submitted', 'Offered Interview', 'Under Review', 'Offered Position', 'Rejected')
drop type if exists status CASCADE;
drop table if exists application_made CASCADE;
CREATE TABLE application_made(
    application_id UUID PRIMARY KEY,
    status_description varchar(100),
    resume_version integer,
    cover_letter_version integer,
    date_of_application varchar(50),
    applicant_id UUID NOT NULL,
    position_id UUID NOT NULL,
    FOREIGN KEY(applicant_id) REFERENCES applicant ON DELETE CASCADE,
    FOREIGN KEY(position_id) REFERENCES job_position_belongs_to ON DELETE CASCADE
);
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('403925c0-9b4e-11ec-b909-0242ac120002', 'Not Started', 5, 1, '2022-01-03', '530ab1f6-9b4d-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('40392886-9b4e-11ec-b909-0242ac120002', 'In Progress', 2, 5, '2021-04-04', '530ab732-9b4d-11ec-b909-0242ac120002', '46851a24-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('403929d0-9b4e-11ec-b909-0242ac120002', 'Submitted', 1, 7, '2021-09-21', '530ab8a4-9b4d-11ec-b909-0242ac120002', '46851be6-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('40392b06-9b4e-11ec-b909-0242ac120002', 'Offered Interview', 4, 3, '2021-11-04', '530abc64-9b4d-11ec-b909-0242ac120002', '46851d9e-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('40392c32-9b4e-11ec-b909-0242ac120002', 'Rejected', 23, 1, '2022-02-02', '530abe12-9b4d-11ec-b909-0242ac120002', '46851f56-9b4e-11ec-b909-0242ac120002');

-- INSERTS FOR DIVISION QUERY (have 1 job position (id: 468516d2-9b4e-11ec-b909-0242ac120002) that every applicant applied to):
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('5a6dc83e-b0a1-11ec-b909-0242ac120002', 'Not Started', 5, 1, '2022-01-03', '530ab732-9b4d-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('5a6dcd2a-b0a1-11ec-b909-0242ac120002', 'Not Started', 5, 1, '2022-01-03', '530ab8a4-9b4d-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('5a6dd324-b0a1-11ec-b909-0242ac120002', 'Not Started', 5, 1, '2022-01-03', '530abc64-9b4d-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');
INSERT INTO application_made(application_id, status_description, resume_version, cover_letter_version, date_of_application, applicant_id, position_id) VALUES ('5a6dd496-b0a1-11ec-b909-0242ac120002', 'Not Started', 5, 1, '2022-01-03', '530abe12-9b4d-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');


drop table if exists attends CASCADE;
CREATE TABLE attends(
    applicant_id UUID,
    university_name varchar(60),
    since_year integer NOT NULL,
    graduation_year integer,
    PRIMARY KEY (applicant_id, university_name),
    FOREIGN KEY(applicant_id) REFERENCES applicant ON DELETE CASCADE,
    FOREIGN KEY(university_name) REFERENCES university ON DELETE CASCADE
);
INSERT INTO attends(applicant_id, university_name, since_year, graduation_year) VALUES ('530ab1f6-9b4d-11ec-b909-0242ac120002', 'University of British Columbia', 2019, 2026);
INSERT INTO attends(applicant_id, university_name, since_year, graduation_year) VALUES ('530ab732-9b4d-11ec-b909-0242ac120002', 'McMaster University', 2020, 2024);
INSERT INTO attends(applicant_id, university_name, since_year, graduation_year) VALUES ('530ab8a4-9b4d-11ec-b909-0242ac120002', 'McGill University', 2021, 2023);
INSERT INTO attends(applicant_id, university_name, since_year, graduation_year) VALUES ('530abc64-9b4d-11ec-b909-0242ac120002', 'University of Toronto', 2018, 2022);
INSERT INTO attends(applicant_id, university_name, since_year, graduation_year) VALUES ('530abe12-9b4d-11ec-b909-0242ac120002', 'Queens University', 2017, 2025);

drop table if exists lives_at_address CASCADE;
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
INSERT INTO lives_at_address(street_address, city, postal_code, region, country, applicant_id) VALUES ('28 Cedarwood Ave. ', 'Toronto', 'E7L 5Y0', 'Ontario', 'Canada', '530ab732-9b4d-11ec-b909-0242ac120002');
INSERT INTO lives_at_address(street_address, city, postal_code, region, country, applicant_id) VALUES ('6 Border Ave. ', 'Vancouver', 'A2N 4N7', 'British Columbia', 'Canada', '530ab8a4-9b4d-11ec-b909-0242ac120002');
INSERT INTO lives_at_address(street_address, city, postal_code, region, country, applicant_id) VALUES ('7724 Bald Hill Ave.', 'Montreal', 'J6R 8B8', 'Quebec', 'Canada', '530abc64-9b4d-11ec-b909-0242ac120002');
INSERT INTO lives_at_address(street_address, city, postal_code, region, country, applicant_id) VALUES ('412 E. Warren Ave. ', 'Kingston', 'E7A 3J3', 'Ontario', 'Canada', '530abe12-9b4d-11ec-b909-0242ac120002');

drop table if exists job_position_compensation CASCADE;
CREATE TABLE job_position_compensation(
    position_title varchar(60) NOT NULL,
    company_id UUID NOT NULL,
    weekly_hours integer NOT NULL,
    salary integer NOT NULL,
    PRIMARY KEY (position_title, company_id),
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO job_position_compensation(position_title, company_id, weekly_hours, salary) VALUES ('Software Engineer Intern', '2f12f85e-9b51-11ec-b909-0242ac120002', 40, 6000);
INSERT INTO job_position_compensation(position_title, company_id, weekly_hours, salary) VALUES ('PM Intern', '2f12fade-9b51-11ec-b909-0242ac120002', 50, 5000);
INSERT INTO job_position_compensation(position_title, company_id, weekly_hours, salary) VALUES ('Data Science Intern', '2f12fc3c-9b51-11ec-b909-0242ac120002', 80, 7500);
INSERT INTO job_position_compensation(position_title, company_id, weekly_hours, salary) VALUES ('Engineering Intern', '2f12ff34-9b51-11ec-b909-0242ac120002', 60, 7000);
INSERT INTO job_position_compensation(position_title, company_id, weekly_hours, salary) VALUES ('Healthcare Consulting Intern', '2f1301aa-9b51-11ec-b909-0242ac120002', 37, 4000);

drop table if exists business_company CASCADE;
CREATE TABLE business_company(
    company_id UUID NOT NULL PRIMARY KEY,
    field_of_business varchar(60) NOT NULL,
    deliverable varchar(60),
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO business_company(company_id, field_of_business, deliverable) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'marketing', 'marketing campaign');
INSERT INTO business_company(company_id, field_of_business, deliverable) VALUES ('2f12fade-9b51-11ec-b909-0242ac120002', 'accounting', 'statement of income');
INSERT INTO business_company(company_id, field_of_business, deliverable) VALUES ('2f12fc3c-9b51-11ec-b909-0242ac120002', 'consulting', 'healthcare consulting');
INSERT INTO business_company(company_id, field_of_business, deliverable) VALUES ('2f12ff34-9b51-11ec-b909-0242ac120002', 'HR', 'hiring report');
INSERT INTO business_company(company_id, field_of_business, deliverable) VALUES ('2f1301aa-9b51-11ec-b909-0242ac120002', 'finance', 'financial statements');

drop table if exists technology_company CASCADE;
CREATE TABLE technology_company(
    company_id UUID NOT NULL PRIMARY KEY,
    tech_stack varchar(60),
    product varchar(60) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO technology_company(company_id, tech_stack, product) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'assembly', 'cell phone');
INSERT INTO technology_company(company_id, tech_stack, product) VALUES ('2f12fade-9b51-11ec-b909-0242ac120002', 'c++', 'search engine');
INSERT INTO technology_company(company_id, tech_stack, product) VALUES ('2f12fc3c-9b51-11ec-b909-0242ac120002', 'python', 'microservice');
INSERT INTO technology_company(company_id, tech_stack, product) VALUES ('2f12ff34-9b51-11ec-b909-0242ac120002', 'swift', 'mobile application');
INSERT INTO technology_company(company_id, tech_stack, product) VALUES ('2f1301aa-9b51-11ec-b909-0242ac120002', 'javascript, html, css', 'web application');

drop table if exists healthcare_company CASCADE;
CREATE TABLE healthcare_company(
    company_id UUID NOT NULL PRIMARY KEY,
    specialty varchar(60) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO healthcare_company(company_id, specialty) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'oncology');
INSERT INTO healthcare_company(company_id, specialty) VALUES ('2f12fade-9b51-11ec-b909-0242ac120002', 'pediatrics');
INSERT INTO healthcare_company(company_id, specialty) VALUES ('2f12fc3c-9b51-11ec-b909-0242ac120002', 'dermatology');
INSERT INTO healthcare_company(company_id, specialty) VALUES ('2f12ff34-9b51-11ec-b909-0242ac120002', 'dentistry');
INSERT INTO healthcare_company(company_id, specialty) VALUES ('2f1301aa-9b51-11ec-b909-0242ac120002', 'medical imaging');

drop table if exists prefers CASCADE;
CREATE TABLE prefers(
    company_id UUID,
    university_name varchar(60),
    PRIMARY KEY(company_id, university_name),
    FOREIGN KEY (company_id) REFERENCES company,
    FOREIGN KEY (university_name) REFERENCES university
);
INSERT INTO prefers(company_id, university_name) VALUES ('2f12f85e-9b51-11ec-b909-0242ac120002', 'University of British Columbia');
INSERT INTO prefers(company_id, university_name) VALUES ('2f12fade-9b51-11ec-b909-0242ac120002', 'McMaster University');
INSERT INTO prefers(company_id, university_name) VALUES ('2f12fc3c-9b51-11ec-b909-0242ac120002', 'McGill University');
INSERT INTO prefers(company_id, university_name) VALUES ('2f12ff34-9b51-11ec-b909-0242ac120002', 'University of Toronto');
INSERT INTO prefers(company_id, university_name) VALUES ('2f1301aa-9b51-11ec-b909-0242ac120002', 'Queens University');

drop table if exists hiring_manager_works_for CASCADE;
CREATE TABLE hiring_manager_works_for(
    emp_id UUID PRIMARY KEY,
    year_hired integer NOT NULL,
    first_name varchar(60) NOT NULL,
    last_name varchar(60) NOT NULL,
    company_id UUID NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company
);
INSERT INTO hiring_manager_works_for(emp_id, year_hired, first_name, last_name, company_id) VALUES ('f1cdb412-9b63-11ec-b909-0242ac120002', 2015, 'Meghan', 'Allen', '2f12f85e-9b51-11ec-b909-0242ac120002');
INSERT INTO hiring_manager_works_for(emp_id, year_hired, first_name, last_name, company_id) VALUES ('f1cdb61a-9b63-11ec-b909-0242ac120002', 2019, 'Elisa', 'Baniassad', '2f12fade-9b51-11ec-b909-0242ac120002');
INSERT INTO hiring_manager_works_for(emp_id, year_hired, first_name, last_name, company_id) VALUES ('f1cdb746-9b63-11ec-b909-0242ac120002', 2017, 'Patrice', 'Belleville', '2f12fc3c-9b51-11ec-b909-0242ac120002');
INSERT INTO hiring_manager_works_for(emp_id, year_hired, first_name, last_name, company_id) VALUES ('f1cdb958-9b63-11ec-b909-0242ac120002', 2020, 'Ivan', 'Beschastnikh', '2f12ff34-9b51-11ec-b909-0242ac120002');
INSERT INTO hiring_manager_works_for(emp_id, year_hired, first_name, last_name, company_id) VALUES ('f1cdbafc-9b63-11ec-b909-0242ac120002', 2011, 'William', 'Bowman', '2f1301aa-9b51-11ec-b909-0242ac120002');

drop table if exists manages CASCADE;
CREATE TABLE manages(
    position_id UUID,
    emp_id UUID,
    PRIMARY KEY(position_id, emp_id),
    FOREIGN KEY (position_id) REFERENCES job_position_belongs_to,
    FOREIGN KEY (emp_id) REFERENCES hiring_manager_works_for
);
INSERT INTO manages(position_id, emp_id) VALUES ('468516d2-9b4e-11ec-b909-0242ac120002', 'f1cdb412-9b63-11ec-b909-0242ac120002');
INSERT INTO manages(position_id, emp_id) VALUES ('46851a24-9b4e-11ec-b909-0242ac120002', 'f1cdb61a-9b63-11ec-b909-0242ac120002');
INSERT INTO manages(position_id, emp_id) VALUES ('46851be6-9b4e-11ec-b909-0242ac120002', 'f1cdb746-9b63-11ec-b909-0242ac120002');
INSERT INTO manages(position_id, emp_id) VALUES ('46851d9e-9b4e-11ec-b909-0242ac120002', 'f1cdb958-9b63-11ec-b909-0242ac120002');
INSERT INTO manages(position_id, emp_id) VALUES ('46851f56-9b4e-11ec-b909-0242ac120002', 'f1cdbafc-9b63-11ec-b909-0242ac120002');

drop table if exists requires CASCADE;
CREATE TABLE requires(
    spec_id UUID,
    position_id UUID,
    PRIMARY KEY(spec_id, position_id),
    FOREIGN KEY (spec_id) REFERENCES specialization_info,
    FOREIGN KEY (position_id) REFERENCES job_position_belongs_to
);
INSERT INTO requires(spec_id, position_id) VALUES ('9660b94a-9b49-11ec-b909-0242ac120002', '468516d2-9b4e-11ec-b909-0242ac120002');
INSERT INTO requires(spec_id, position_id) VALUES ('830af072-9b49-11ec-b909-0242ac120002', '46851a24-9b4e-11ec-b909-0242ac120002');
INSERT INTO requires(spec_id, position_id) VALUES ('8704b546-9b49-11ec-b909-0242ac120002', '46851be6-9b4e-11ec-b909-0242ac120002');
INSERT INTO requires(spec_id, position_id) VALUES ('8d955e4c-9b49-11ec-b909-0242ac120002', '46851d9e-9b4e-11ec-b909-0242ac120002');
INSERT INTO requires(spec_id, position_id) VALUES ('914da9a4-9b49-11ec-b909-0242ac120002', '46851f56-9b4e-11ec-b909-0242ac120002');

drop table if exists oversees CASCADE;
CREATE TABLE oversees(
    emp_id UUID,
    applicant_id UUID,
    PRIMARY KEY(emp_id, applicant_id),
    FOREIGN KEY (emp_id) REFERENCES hiring_manager_works_for ON DELETE CASCADE,
    FOREIGN KEY (applicant_id) REFERENCES applicant ON DELETE CASCADE
);
INSERT INTO oversees(emp_id, applicant_id) VALUES ('f1cdb412-9b63-11ec-b909-0242ac120002', '530ab1f6-9b4d-11ec-b909-0242ac120002');
INSERT INTO oversees(emp_id, applicant_id) VALUES ('f1cdb61a-9b63-11ec-b909-0242ac120002', '530ab732-9b4d-11ec-b909-0242ac120002');
INSERT INTO oversees(emp_id, applicant_id) VALUES ('f1cdb746-9b63-11ec-b909-0242ac120002', '530ab8a4-9b4d-11ec-b909-0242ac120002');
INSERT INTO oversees(emp_id, applicant_id) VALUES ('f1cdb958-9b63-11ec-b909-0242ac120002', '530abc64-9b4d-11ec-b909-0242ac120002');
INSERT INTO oversees(emp_id, applicant_id) VALUES ('f1cdbafc-9b63-11ec-b909-0242ac120002', '530abe12-9b4d-11ec-b909-0242ac120002');

ALTER TABLE specialization_info
    ADD CONSTRAINT totalSpecializationUniversity FOREIGN KEY (spec_id) REFERENCES offers
        DEFERRABLE INITIALLY DEFERRED;