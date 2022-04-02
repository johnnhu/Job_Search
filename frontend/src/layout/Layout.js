import { Container, Row, Col } from "react-bootstrap"
import Header from "../components/Header";

const Layout = ({ children }) => {
    return (
        <Container>
            <Row>
                <Col><Header /></Col>
            </Row>
            <Row>
                <Col>{children}</Col>
            </Row>
        </Container>
    )
}

export default Layout;
