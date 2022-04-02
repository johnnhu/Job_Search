import { useState } from "react";
import {
    Table,
    // ButtonGroup,
    Button,
    Modal
} from "react-bootstrap"
import GenericForm from "./GenericForm";

const GenericTable = ({
    schema,
    data
}) => {
    const [showDelete, setShowDelete] = useState(false);
    const [showUpdate, setShowUpdate] = useState(false);

    const [selectedRow, setSelectedRow] = useState({});

    const handleCloseDelete = () => setShowDelete(false);
    const handleShowDelete = () => setShowDelete(true);

    const handleCloseUpdate = () => setShowUpdate(false);
    const handleShowUpdate = () => setShowUpdate(true);

    const { rows } = data;

    if (rows === undefined) {
        return "Loading..."
    }

    const parseHeaders = (rows) => {
        if (rows.length === 0) return ['']

        return Object.keys(rows[0])
    }

    return (
        <>
            {/* Main table data */}
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                        {parseHeaders(rows).map((header) => (
                            <th key={header}>{header}</th>
                        ))}
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {rows.map((row) => {
                        return (
                            <tr>
                                {Object.values(row).map((value) => {
                                    return (
                                        <td>{value}</td>
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

            {/* Edit entry modal */}
            <Modal show={showUpdate} onHide={handleCloseUpdate}>
                <Modal.Header closeButton>
                    <Modal.Title>Update entry</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <GenericForm schema={schema} data={selectedRow} />
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
                    <Button variant="danger" onClick={handleCloseDelete}>
                        Submit
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}

export default GenericTable;
