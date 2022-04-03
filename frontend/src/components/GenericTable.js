import { useState, useEffect } from "react";
import { toast } from 'react-toastify';
import {
    Table,
    // ButtonGroup,
    Button,
    Modal
} from "react-bootstrap"
import GenericForm from "./GenericForm";
import { BASE_URL } from '../utils/constants'
import { APPLICANT } from "../utils/schemas";

const getId = (schema, selectedRow) => {
    if (schema === APPLICANT) {
        return selectedRow['applicant_id'];
    }

    return Object.values(selectedRow)[0];
}

const GenericTable = ({
    path,
    schema,
}) => {
    const [data, setData] = useState([]);
    const [refetch, setRefetch] = useState(0);
    const [loading, setLoading] = useState(true);

    const [showCreate, setShowCreate] = useState(false);
    const [showUpdate, setShowUpdate] = useState(false);
    const [showDelete, setShowDelete] = useState(false);

    const [selectedRow, setSelectedRow] = useState({});

    const notify = (message) => toast(message || 'Task completed!');

    const handleCloseCreate = () => setShowCreate(false);
    const handleShowCreate = () => setShowCreate(true);

    const handleCloseUpdate = () => setShowUpdate(false);
    const handleShowUpdate = () => setShowUpdate(true);

    const handleCloseDelete = () => setShowDelete(false);
    const handleShowDelete = () => setShowDelete(true);

    const doFetch = async () => {
        if (path !== 'applicant') {
            setData({
                rows: [{
                    'columnA': 'valueA 1',
                    'columnB': 'valueB 1',
                    'columnC': 'valueC 1'
                },
                {
                    'columnA': 'valueA 2',
                    'columnB': 'valueB 2',
                    'columnC': 'valueC 2'
                }]
            })

            setLoading(false);
        } else {
            setLoading(true);

            try {
                const result = await fetch(`${BASE_URL}/${path}s`)
                console.log(result);

                const body = await result.json();
                console.log(body);

                const obj = {
                    rows: body
                }

                setData(obj);
            } catch (error) {
                console.error(error)
            } finally {
                setLoading(false)
            }
        }
    }

    useEffect(() => {
        doFetch();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    useEffect(() => {
        console.log({ refetch });
        if (refetch > 0) {
            doFetch();
        }
        setRefetch(0);
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [refetch]);

    const parseHeaders = (rows) => {
        if (rows.length === 0) return ['']

        return Object.keys(rows[0])
    }

    const doRefetch = () => {
        setRefetch(refetch + 1);
    }

    const doDelete = async () => {
        setLoading(true);

        try {
            console.log(`${BASE_URL}/${path}/${getId(schema, selectedRow)}`);
            const response = await fetch(`${BASE_URL}/${path}/${getId(schema, selectedRow)}`, {
                method: 'DELETE',
            })
            console.log(response);

            const data = await response.text();

            console.log('Completed form query!', { data });
            notify('Data deleted!')

            doRefetch();
        } catch (error) {
            console.error(error)
        } finally {
            setLoading(false)
        }
    }

    if (loading) return 'Loading...'
    return (
        <>
            {/* Main table data */}
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                        {parseHeaders(data.rows).map((header) => (
                            <th key={header}>{header}</th>
                        ))}
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {data.rows.map((row, index) => {
                        return (
                            <tr key={index}>
                                {Object.values(row).map((value, index) => {
                                    return (
                                        <td key={index}>{value}</td>
                                    )
                                })}
                                <td>
                                    <Button onClick={() => {
                                        setSelectedRow(row)
                                        handleShowUpdate()
                                    }} variant="primary" size="sm">Update</Button>{` `}
                                    <Button onClick={() => {
                                        setSelectedRow(row)
                                        handleShowDelete()
                                    }} variant="danger" size="sm">Delete</Button>
                                </td>
                            </tr>
                        )
                    })}
                </tbody>
            </Table>

            <Button onClick={() => {
                handleShowCreate()
            }} variant="success" size="sm">Create new entry</Button>

            {/* Create entry modal */}
            <Modal show={showCreate} onHide={handleCloseCreate}>
                <Modal.Header closeButton>
                    <Modal.Title>Create entry</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <GenericForm path={path} schema={schema} data={{}} handleClose={handleCloseCreate} doRefetch={doRefetch} update={false} />
                </Modal.Body>
            </Modal>

            {/* Edit entry modal */}
            <Modal show={showUpdate} onHide={handleCloseUpdate}>
                <Modal.Header closeButton>
                    <Modal.Title>Update entry</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <GenericForm path={path} schema={schema} data={selectedRow} handleClose={handleCloseUpdate} doRefetch={doRefetch} update={true} />
                </Modal.Body>
            </Modal>

            {/* Delete entry modal */}
            <Modal show={showDelete} onHide={handleCloseDelete}>
                <Modal.Header closeButton>
                    <Modal.Title>Are you sure you'd like to delete this entry?</Modal.Title>
                </Modal.Header>
                <Modal.Body>Click 'submit' to confirm your deletion.
                    <br /><br />
                    <pre>{`${JSON.stringify(selectedRow, null, 2)}`}</pre>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseDelete}>
                        Close
                    </Button>
                    <Button variant="danger" onClick={() => {
                        doDelete()
                        handleCloseDelete()
                    }}>
                        Submit
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}

export default GenericTable;
