import GenericTable from '../../components/GenericTable';
import Layout from '../../layout/Layout'

import { ADDRESS } from '../../utils/schemas';

const Address = () => {
    return (
        <Layout title={"Address"}>
            <GenericTable path={'address'} schema={ADDRESS} />
        </Layout>
    );
}

export default Address;
