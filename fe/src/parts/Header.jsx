import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import Nav from "react-bootstrap/Nav";
import { Link } from "react-router-dom";
import logo from "../assets/images/logo.png";

const Header = () => {
  return (
    <header className="bg-dark text-white">
      <div className="row">
        <div className="navbar-brand col-md-3 d-flex justify-content-center">
          <img src={logo} width={"40px"} height={"40px"} />
        </div>
        <nav className="navbar navbar-expand-lg navbar-dark container col-md-6 d-flex justify-content-center">
          <ul className="navbar-nav">
            <li className="nav-item">
              <a className="nav-link active" aria-current="page" href="#">
                Home
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                About
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Services
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Contact
              </a>
            </li>
          </ul>
        </nav>
        <div className="navbar-brand col-md-3 d-flex justify-content-center">
          <div>
            <i className="bi bi-bell-fill"></i>
          </div>
          <div>
            <i className="bi bi-cart-fill"></i>
          </div>
          <div>
            <i className="bi bi-person-circle"></i>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
