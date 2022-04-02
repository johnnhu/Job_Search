import { Form, Button } from 'react-bootstrap'

const GenericForm = ({ schema, data }) => {

    // TODO: add in value from data using Formik
    const typeToComponent = (type) => {
        switch (type) {
            case 'string':
            case 'phone':
            default:
                return <Form.Control />
        }
    }

    return (
        <>
            <Form>
                {Object.entries(schema).map(([key, value]) => {
                    return (
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>{key}</Form.Label>
                            {typeToComponent(value)}
                        </Form.Group>
                    )
                })}
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form >
        </>
    )
}

export default GenericForm
