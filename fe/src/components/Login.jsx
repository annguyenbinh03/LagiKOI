import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import InputGroup from "react-bootstrap/InputGroup";

import { Link, replace, useLocation, useNavigate } from "react-router-dom";
import Row from "react-bootstrap/Row";
import { useEffect, useState } from "react";
import { getToken } from "../api/authentication";
import useAuth from "../hooks/useAuth";
import { jwtDecode } from "jwt-decode";
import { Bounce, toast } from "react-toastify";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const { setAuth } = useAuth();

  const navigate = useNavigate();
  const location = useLocation();
  const from = location.state?.from?.pathname || "/";

  const handleChangeUsername = (e) => {
    setUsername(e.target.value);
  };

  const handleChangePassword = (e) => {
    setPassword(e.target.value);
  };

  const getRoles = (scopes) => {
    let roles = [];
    scopes.forEach((item) => {
      if (item.startsWith("ROLE_")) roles.push(item);
    });
    return roles;
  };

  const getAuthorities = (scopes) => {
    let authorities = [];
    scopes.forEach((item) => {
      if (!item.startsWith("ROLE_")) authorities.push(item);
    });
    return authorities;
  };

  const handleClickSubmit = async () => {
    try {
      const response = await getToken(username, password);
      const token = response.result.token;
      const decoded = jwtDecode(token);
      console.log(decoded);
      localStorage.setItem("lagikoiToken", token);
      const scopeArray = decoded.scope.split(" ");
      const roles = getRoles(scopeArray);
      const authorities = getAuthorities(scopeArray);
      setAuth({ username, roles, authorities, token });
      toast.success("Đăng nhập thành công!", {
        position: "top-right",
        autoClose: 3000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
        transition: Bounce,
      });
      if (from === "/") {
        if (roles.includes("ROLE_ADMIN")) navigate("/admin", { replace: true });
        else navigate("/", { replace: true });
      } else navigate(from, { replace: true });
    } catch (error) {
      console.log(error);
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
