import { useState } from "react";
import { Field, Formik } from 'formik'
import { Button, Container, Row, Col, Modal, Form } from 'react-bootstrap'
import RangeSlider from 'react-bootstrap-range-slider';
import Layout from '../layout/Layout'
import { BASE_URL } from "../utils/constants";

const Insights = () => {
    const [data, setData] = useState({});
    const [show, setShow] = useState(false);
    const [loading, setLoading] = useState(false);

    const [salary, setSalary] = useState(0);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const performQuery = async (path = '') => {
        setLoading(true);

        try {
            const response = await fetch(`${BASE_URL}/${path}`)
            const data = await response.json();

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
                {/* /selection/:salary */}
                <Row>
                    <Col xs={2}>Find those with salaries above some threshold</Col>
                    <Col>
                        <Form.Group controlId="salary">
                            <RangeSlider min={0} max={10000} value={salary} onChange={changeEvent => setSalary(changeEvent.target.value)} />
                        </Form.Group>
                    </Col>
                    <Col xs={2}><Button onClick={async () => {
                        await performQuery(`selection/${salary}`);
                    }} variant="primary" type="submit">Go!</Button></Col>
                </Row>

                <br />

                { /* /project/:column */}
                <Row>
                    <Col xs={2}>{`Select a certain column (i.e., perform a projection)`}</Col>
                    <Formik initialValues={{ columnName: 'column_name' }} onSubmit={async (values) => {
                        await performQuery(`projection/${values.columnName}`);
                    }}>
                        {({ handleChange, handleSubmit, handleBlur, values, errors }) => (
                            <>
                                <Col>
                                    <Form>
                                        <Field name="columnName">
                                            {({ field, form, meta }) => (
                                                <Form.Group controlId="columnName">
                                                    <Form.Control value={field.value} onChange={field.onChange} placeholder="column_name" />
                                                </Form.Group>
                                            )}
                                        </Field>

                                    </Form>
                                </Col>
                                <Col xs={2}><Button onClick={handleSubmit} variant="primary" type="submit">Go!</Button></Col>
                            </>
                        )}
                    </Formik>
                </Row>

                <br />

                { /* /join */}
                <Row>
                    <Col xs={2}>{`Perform a join`}</Col>
                    <Col xs={2}><Button onClick={() => {
                        performQuery(`/join`)
                    }} variant="primary" type="submit">Go!</Button></Col>
                </Row>

                <br />

                { /* /aggregation */}
                <Row>
                    <Col xs={2}>{`Perform an aggregation query`}</Col>
                    <Col xs={2}><Button onClick={() => {
                        performQuery(`/aggregation`)
                    }} variant="primary" type="submit">Go!</Button></Col>
                </Row>

                <br />

                { /* /nestedAggergation */}
                <Row>
                    <Col xs={2}>{`Perform a nested aggregation query`}</Col>
                    <Col xs={2}><Button onClick={() => {
                        performQuery(`/nestedAggregation`)
                    }} variant="primary" type="submit">Go!</Button></Col>
                </Row>

                <br />

                { /* /division */}
                <Row>
                    <Col xs={2}>{`Perform a division query`}</Col>
                    <Col xs={2}><Button onClick={() => {
                        performQuery(`/division`)
                    }} variant="primary" type="submit">Go!</Button></Col>
                </Row>

                <br />

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
