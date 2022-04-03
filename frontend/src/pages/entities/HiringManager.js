import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { HIRING_MANAGER } from "../../utils/schemas";

const HiringManager = () => {
    return (
        <Layout title={"HiringManager"}>
            <GenericTable path={"hiringManager"} schema={HIRING_MANAGER} />
        </Layout>
    );
};

export default HiringManager;
