import GenericTable from "../../components/GenericTable";
import Layout from "../../layout/Layout";

import { OFFERS } from "../../utils/schemas";

const Offers = () => {
  return (
    <Layout title={"Offers"}>
      <GenericTable path={"offers"} schema={OFFERS} />
    </Layout>
  );
};

export default Offers;
