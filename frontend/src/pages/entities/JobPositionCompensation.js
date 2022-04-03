import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { JOB_POSITION_COMPENSATION } from "../../utils/schemas";

const JobPositionCompensation = () => {
  return (
    <Layout title={"JobPositionCompensation"}>
      <GenericTable
        path={"jobPositionCompensation"}
        schema={JOB_POSITION_COMPENSATION}
      />
    </Layout>
  );
};

export default JobPositionCompensation;
