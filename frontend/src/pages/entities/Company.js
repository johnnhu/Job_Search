import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { COMPANY } from "../../utils/schemas";

const Company = () => {
    return (
        <Layout title={"Company"}>
            <GenericTable path={"company"} schema={COMPANY} />
        </Layout>
    );
};

export default Company;
