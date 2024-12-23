import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import InputGroup from "react-bootstrap/InputGroup";

import { Link } from "react-router-dom";
import Row from "react-bootstrap/Row";
import { useEffect, useState } from "react";
import { getToken } from "../api/authentication";

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleChangeUsername = (e) => {
    setUsername(e.target.value);
  };

  const handleChangePassword = (e) => {
    setPassword(e.target.value);
  };

  const handleClickSubmit = async () => {
    try {
      var response = await getToken(username, password);
      console.log(response)
    } catch (error) {
      console.log(error)
    }
  };



  return (
    <Container>
      <div>
        <div className="fs-3 fw-bold">Login</div>
        <div>
          <Form className="mt-3">
            <InputGroup className="mb-3">
              <InputGroup.Text id="basic-addon1">
                <i className="bi bi-person-circle"></i>
              </InputGroup.Text>
              <Form.Control
                value={username}
                onChange={(e) => handleChangeUsername(e)}
                placeholder="Enter username"
                aria-label="Username"
                aria-describedby="basic-addon1"
              />
            </InputGroup>
            <InputGroup className="mb-3">
              <InputGroup.Text id="basic-addon1">
                <i
                  className="bi bi-lock-fill"
                  style={{
                    transform: "scaleX(1.3)",
                  }}
                ></i>
              </InputGroup.Text>
              <Form.Control
                value={password}
                onChange={(e) => handleChangePassword(e)}
                placeholder="Enter password"
                aria-label="Password"
                aria-describedby="basic-addon1"
              />
            </InputGroup>
            {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
            <Form.Check type="checkbox" label="Check me out" />
          </Form.Group> */}
            <Button variant="primary" onClick={() => handleClickSubmit()}>
              Submit
            </Button>
          </Form>
          <Row className="mt-3">
            <Link to="/">Visit Our Homepage</Link>
          </Row>
        </div>
      </div>
    </Container>
  );
};

export default Login;
