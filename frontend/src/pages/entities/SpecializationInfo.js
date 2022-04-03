import GenericTable from '../../components/GenericTable';
import Layout from '../../layout/Layout'

import { SPECIALIZATION_INFO } from '../../utils/schemas';

const SpecializationInfo = () => {
    return (
        <Layout title={"SpecializationInfo"}>
            <GenericTable path={'specializationInfo'} schema={SPECIALIZATION_INFO} />
        </Layout>
    );
}

export default SpecializationInfo;
