import { Container, Row, Col } from "react-bootstrap"
import Header from "../components/Header";

const Layout = ({ children, title }) => {
    return (
        <Container>
            <Row>
                <Col><Header /></Col>
            </Row>
            <Row>
                <h1>{title}</h1>
                <Col>{children}</Col>
            </Row>
        </Container>
    )
}

export default Layout;
