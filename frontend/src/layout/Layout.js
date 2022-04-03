import { Container, Row, Col } from "react-bootstrap";
import Header from "../components/Header";

const Layout = ({ children, title }) => {
  return (
    <Container>
      <Row>
        <Col>
          <Header />
        </Col>
      </Row>
      <Row>
        <Col>
          <h1>{title}</h1>
        </Col>
      </Row>
      <Row>
        <Col>{children}</Col>
      </Row>
      <footer className="custom-footer">
        Made by Michael DeMarco, Emily Chen, and Jonathan Hu for CPSC 304,
        2021W2.
      </footer>
    </Container>
  );
};

export default Layout;
