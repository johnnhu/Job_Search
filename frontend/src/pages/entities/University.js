import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { UNIVERSITY } from "../../utils/schemas";

const University = () => {
  return (
    <Layout title={"University"}>
      <GenericTable path={"university"} schema={UNIVERSITY} />
    </Layout>
  );
};

export default University;
