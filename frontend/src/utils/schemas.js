export const ADDRESS = {
    streetAddress: 'string',
    postalCode: 'string',
    city: 'string',
    region: 'string',
    country: 'string'
}

export const APPLICANT = {
    applicant_id: 'string',
    applicant_name: 'string',
    applicant_phone: 'phone',
    applicant_email: 'string',
    spec_id: 'string',
    supervisor_id: 'string',
    university_name: 'string'
}

export const APPLICATION_MADE = {
    applicationId: 'string',
    status: 'string',
    resumeVersion: 'string',
    coverLetterVersion: 'string',
    dateOfApplication: 'date',
    applicantId: 'string',
    positionId: 'string'
}

export const ATTENDS = {
    applicantId: 'string',
    universityName: 'string',
    sinceYear: 'string',
    graduationYear: 'string'
}

export const COMPANY = {
    companyId: 'string',
    companyName: 'string',
    numEmployees: 'string'
}

export const COOP_SUPERVISOR_WORKS_AT = {
    supervisorId: 'string',
    supervisorName: 'string',
    supervisorPhone: 'string',
    supervisorEmail: 'string',
    capacity: 'string',
    workedSince: 'string',
    universityName: 'string'
}

export const HIRING_MANAGER = {
    empId: 'string',
    yearHired: 'date',
    firstName: 'string',
    lastName: 'string'
}

export const JOB_POSITION_BELONGS_TO = {
    positionId: 'string',
    positionTitle: 'string',
    isFilled: 'string',
    companyId: 'string'
}

export const JOB_POSITION_COMPENSATION = {
    positionTitle: 'string',
    companyId: 'string',
    weeklyHours: 'string',
    salary: 'string'
}

export const OFFERS = {
    universityName: 'string',
    specId: 'string'
}

export const SPECIALIZATION_CREDITS = {
    specId: 'string',
    major: 'string',
    numCredits: 'string',
    isHonours: 'string',
    degreeType: 'string'
}

export const SPECIALIZATION_INFO = {
    specId: 'string',
    major: 'string',
    minor: 'string',
    isHonours: 'string',
    degreeType: 'string'
}

export const UNIVERSITY = {
    universityName: 'string',
    yearEstablished: 'string',
    region: 'string',
    country: 'string'
}
