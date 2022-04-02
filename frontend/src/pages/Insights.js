import { useState } from "react";
import { Button, Container, Row, Col, Modal, Spinner } from 'react-bootstrap'
import Layout from '../layout/Layout'
import { BASE_URL } from "../utils/constants";

const Insights = () => {
    const [data, setData] = useState({});
    const [show, setShow] = useState(false);
    const [loading, setLoading] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const performQuery = async () => {
        setLoading(true);

        try {
            const response = await fetch(`${BASE_URL}/hello`)
            console.log(response);

            const data = await response.json();
            console.log(data);

            setData(data)
            handleShow()
        } catch (error) {
            console.error(error)
        } finally {
            setLoading(false)
        }
    }

    return (
        <Layout>
            <h1>Insights</h1>
            <Container>
                <Row>
                    <Col xs={2}>Custom query</Col>
                    <Col xs={2}><Button onClick={() => {
                        performQuery()
                    }} variant="primary" type="submit">Go!</Button></Col>
                    {loading &&
                        <Col>
                            <Spinner animation="border" role="status">
                                <span className="visually-hidden">Loading...</span>
                            </Spinner>
                        </Col>
                    }
                </Row>
            </Container>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Result</Modal.Title>
                </Modal.Header>
                <Modal.Body>Here's your result!
                    <br /><br />
                    <pre>{`${JSON.stringify(data, null, 2)}`}</pre>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        </Layout >
    );
}

export default Insights;
