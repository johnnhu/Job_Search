import { Nav, NavDropdown, Navbar, Container } from "react-bootstrap";

const Header = () => {
    return (
        <Navbar bg="light" expand="lg">
            <Container>
                <Navbar.Brand href="/">jSearch</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/about">About</Nav.Link>
                        <Nav.Link href="/insights">Insights</Nav.Link>
                        <NavDropdown title="Entities" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/entities/address">
                                Address
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/applicants">
                                Applicants
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/applicationMade">
                                ApplicationMade
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/attends">
                                Attends
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/company">
                                Company
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/coopSupervisorWorksAt">
                                CoopSupervisorWorksAt
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/hiringManager">
                                HiringManager
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/jobPositionBelongsTo">
                                JobPositionBelongsTo
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/jobPositionCompensation">
                                JobPositionCompensation
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/message">
                                Message
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/offers">
                                Offers
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/specializationCredits">
                                SpecializationCredits
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/specializationInfo">
                                SpecializationInfo
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/entities/university">
                                University
                            </NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default Header;
