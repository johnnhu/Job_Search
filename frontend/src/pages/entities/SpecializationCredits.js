import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { SPECIALIZATION_CREDITS } from "../../utils/schemas";

const SpecializationCredits = () => {
    return (
        <Layout title={"SpecializationCredits"}>
            <GenericTable
                path={"specializationCredits"}
                schema={SPECIALIZATION_CREDITS}
            />
        </Layout>
    );
};

export default SpecializationCredits;
