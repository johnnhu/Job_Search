import GenericTable from '../../components/GenericTable';
import Layout from '../../layout/Layout'

import { ATTENDS } from '../../utils/schemas';

const Attends = () => {
    return (
        <Layout title={"Attends"}>
            <GenericTable path={'attends'} schema={ATTENDS} />
        </Layout>
    );
}

export default Attends;
