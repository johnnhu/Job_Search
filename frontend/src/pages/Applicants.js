import { useState, useEffect } from 'react';
import GenericTable from '../components/GenericTable';
import Layout from '../layout/Layout'

import { APPLICANT } from '../utils/schemas';

const Applicants = () => {
    const [applicants, setApplicants] = useState([]);

    useEffect(() => {
        const doFetch = () => {
            return {
                rows: [
                    {
                        applicantId: "1",
                        applicantName: "Michael DeMarco",
                        applicantPhone: "7806809634",
                        specId: "2",
                        supervisorId: "3",
                        universityName: "UBC",
                    }
                ]
            }
        }

        setApplicants(doFetch());
    }, []);

    return (
        <Layout title={"Applicants"}>
            <GenericTable schema={APPLICANT} data={applicants} />
        </Layout>
    );
}

export default Applicants;
