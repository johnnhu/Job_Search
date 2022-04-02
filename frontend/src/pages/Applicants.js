import { useState, useEffect } from 'react';
import GenericTable from '../components/GenericTable';
import Layout from '../layout/Layout'

const Applicants = () => {
    const [applicants, setApplicants] = useState([]);

    useEffect(() => {
        const doFetch = () => {
            return {
                headers: [
                    "fname",
                    "lname",
                    "age",
                    "height",
                ],
                rows: [
                    {
                        fname: "Michael",
                        lname: "DeMarco",
                        age: 20,
                        height: "5'6\"",
                    }
                ]
            }
        }

        setApplicants(doFetch());
    }, []);

    return (
        <Layout>
            <h1>Applicants</h1>
            <h3>Current Applicants</h3>
            <GenericTable data={applicants} />
        </Layout>
    );
}

export default Applicants;
