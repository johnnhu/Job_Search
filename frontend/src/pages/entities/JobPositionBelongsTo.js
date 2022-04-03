import GenericTable from '../../components/GenericTable';
import Layout from '../../layout/Layout'

import { JOB_POSITION_BELONGS_TO } from '../../utils/schemas';

const JobPositionBelongsTo = () => {
    return (
        <Layout title={"JobPositionBelongsTo"}>
            <GenericTable path={'jobPositionBelongsTo'} schema={JOB_POSITION_BELONGS_TO} />
        </Layout>
    );
}

export default JobPositionBelongsTo;
