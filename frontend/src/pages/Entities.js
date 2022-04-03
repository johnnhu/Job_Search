import { Link } from 'react-router-dom';
import Layout from '../layout/Layout'

const Entities = () => {
    return (
        <Layout title={'Entities'}>
            <ul>
                <li><Link to={'/entities/applicants'}>Applicants</Link></li>
            </ul>
        </Layout>
    );
}

export default Entities;
