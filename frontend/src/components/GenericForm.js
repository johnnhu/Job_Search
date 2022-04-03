import { useState } from 'react'
import { toast } from 'react-toastify';
import { Field, Formik } from 'formik'
import { Form, Button, FormGroup, FormLabel } from 'react-bootstrap'
import { BASE_URL } from '../utils/constants'

const GenericForm = ({ path, schema, data, handleClose, doRefetch, update }) => {
    const [loading, setLoading] = useState(false)

    const notify = (message) => toast(message || 'Task completed!');

    // TODO: add in value from data using Formik
    const typeToComponent = (type, value, onChange) => {
        switch (type) {
            case 'date':
                return <Form.Control type={'text'} value={value} onChange={onChange} placeholder={'YYYY-MM-DD'} />
            case 'string':
            case 'phone':
            default:
                return <Form.Control type={'text'} value={value} onChange={onChange} />
        }
    }

    const performQuery = async (path = '', values) => {
        setLoading(true);

        try {
            // TODO: implement; this currently throws an error
            const response = await fetch(`${BASE_URL}/${path}`, {
                method: update ? 'PUT' : 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(values)
            })
            const data = await response.json();

            console.log('Completed form query!', { data });
            notify('Completed query!')

            doRefetch();
        } catch (error) {
            console.error(error)
        } finally {
            setLoading(false)
        }
    }

    return (
        <>
            <Formik initialValues={data} onSubmit={async (values) => {
                await performQuery(path, values);
                handleClose();
            }}>
                {({ handleChange, handleSubmit, handleBlur, values, errors }) => (
                    <Form>
                        <>
                            {Object.entries(schema).map(([key, value], index) => {
                                return (
                                    <div key={`${key}-${index}`}>
                                        <Field
                                            name={key}
                                        >
                                            {({ field, form, meta }) => (
                                                <FormGroup controlId={key}>
                                                    <FormLabel>
                                                        {key}
                                                    </FormLabel>
                                                    {typeToComponent(value, field.value, field.onChange)}
                                                </FormGroup>
                                            )}
                                        </Field>
                                        <br />
                                    </div>
                                )
                            })}
                        </>
                        <Button onClick={handleSubmit} variant="primary" type="submit">
                            {loading ? 'Submitting...' : 'Submit'}
                        </Button>
                    </Form>
                )}
            </Formik>
        </>
    )
}

export default GenericForm
