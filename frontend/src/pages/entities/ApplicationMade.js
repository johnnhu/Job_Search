import GenericTable from '../../components/GenericTable';
import Layout from '../../layout/Layout'

import { APPLICATION_MADE } from '../../utils/schemas';

const ApplicationMade = () => {
    return (
        <Layout title={"ApplicationMade"}>
            <GenericTable path={'applicationMade'} schema={APPLICATION_MADE} />
        </Layout>
    );
}

export default ApplicationMade;
