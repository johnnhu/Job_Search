import { Container, Row, Col } from "react-bootstrap"
import Header from "../components/Header";

const Layout = (props) => {
    return (
        <Container>
            <Row>
                <Col><Header /></Col>
            </Row>
            <Row>
                <Col>{props.children}</Col>
            </Row>
        </Container>
    )
}

export default Layout;
