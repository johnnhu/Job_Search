import GenericTable from '../../components/GenericTable';
import Layout from '../../layout/Layout'

import { APPLICANT } from '../../utils/schemas';

const Applicants = () => {
    return (
        <Layout title={"Applicants"}>
            <GenericTable path={'applicant'} schema={APPLICANT} />
        </Layout>
    );
}

export default Applicants;
