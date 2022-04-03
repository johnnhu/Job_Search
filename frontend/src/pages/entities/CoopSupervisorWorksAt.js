import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { COOP_SUPERVISOR_WORKS_AT } from "../../utils/schemas";

const CoopSupervisorWorksAt = () => {
  return (
    <Layout title={"CoopSupervisorWorksAt"}>
      <GenericTable
        path={"coopSupervisorWorksAt"}
        schema={COOP_SUPERVISOR_WORKS_AT}
      />
    </Layout>
  );
};

export default CoopSupervisorWorksAt;
