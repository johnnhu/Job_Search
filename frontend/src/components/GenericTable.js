import { useState } from "react";
import {
    Table,
    // ButtonGroup,
    Button,
    Modal
} from "react-bootstrap"

const GenericTable = ({
    data
}) => {
    const [show, setShow] = useState(false);
    const [selectedRow, setSelectedRow] = useState({});

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const { headers, rows } = data;

    if (headers === undefined || rows === undefined) {
        return "Loading..."
    }

    return (
        <>
            {/* Main table data */}
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                        {headers.map((header) => (
                            <th key={header}>{header}</th>
                        ))}
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {rows.map((row) => {
                        console.log({ row })
                        return (
                            <tr>
                                {Object.values(row).map((value) => {
                                    return (
                                        <td>{value}</td>
                                    )
                                })}
                                <td>
                                    <Button variant="primary" size="sm">Update</Button>{` `}
                                    <Button onClick={() => {
                                        setSelectedRow(row)
                                        handleShow()
                                    }} variant="danger" size="sm">Delete</Button>
                                </td>
                            </tr>
                        )
                    })}
                </tbody>
            </Table>

            {/* Edit entry modal */}
            {/* TODO! */}

            {/* Delete entry modal */}
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Are you sure you'd like to delete this entry?</Modal.Title>
                </Modal.Header>
                <Modal.Body>Click 'submit' to confirm your deletion.
                    <br /><br />
                    <pre>{`${JSON.stringify(selectedRow, null, 2)}`}</pre>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="danger" onClick={handleClose}>
                        Submit
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}

export default GenericTable;
