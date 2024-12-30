import Dropdown from "react-bootstrap/Dropdown";
import { Link } from "react-router-dom";
import logo from "../assets/images/logo.png";
import style from "../assets/scss/Header.module.scss";
import { useState } from "react";

const Header = () => {
  const [showFishDropDown, setShowFishDropDown] = useState(false);
  const [showAccessoryDropDown, setAccessoryDropDown] = useState(false);

  return (
    <header className={`sticky-top ${style.header}`}>
      <div className="container">
        <div className="row text-center">
          <div className="navbar-brand col-md-3 d-flex justify-content-center align-items-center">
            <img src={logo} width={"40px"} height={"40px"} />
          </div>
          <nav className="navbar navbar-expand-lg navbar-dark col-md-6 p-0">
            <div className="navbar-nav row h-100 w-100 p-0">
              <div className={`nav-item col-md-2 ${style.nav__item}`}>
                <Link to="/">TRANG CHỦ</Link>
              </div>
              <Dropdown
                className={`nav-item col-md-2 ${style.nav__item}`}
                show={showFishDropDown}
                onMouseLeave={() => setShowFishDropDown(false)}
                onMouseOver={() => setShowFishDropDown(true)}
              >
                <Dropdown.Toggle
                  as="button"
                  className={`${style.dropdown__toggle} py-0`}
                >
                  <div>CÁ KOI</div>
                </Dropdown.Toggle>

                <Dropdown.Menu className={`${style.dropdown__menu}`}>
                  <Link to={"/fishs"}>KOE</Link>
                  <Link to={"/fishs"}>SIRO</Link>
                  <Link to={"/fishs"}>BENIGOI</Link>
                </Dropdown.Menu>
              </Dropdown>
              <Dropdown
                className={`nav-item col-md-2 ${style.nav__item}`}
                show={showAccessoryDropDown}
                onMouseLeave={() => setAccessoryDropDown(false)}
                onMouseOver={() => setAccessoryDropDown(true)}
              >
                <Dropdown.Toggle
                  as="button"
                  className={`${style.dropdown__toggle} py-0`}
                >
                  <div>PHỤ KIỆN</div>
                </Dropdown.Toggle>

                <Dropdown.Menu className={`${style.dropdown__menu}`}>
                  <Link to={"/under-construction"}>THỨC ĂN</Link>
                  <Link to={"/under-construction"}>MÁY BƠM</Link>
                  <Link to={"/under-construction"}>TRANG TRÍ</Link>
                </Dropdown.Menu>
              </Dropdown>
              <div className={`nav-item col-md-2 ${style.nav__item}`}>
                <Link to="/under-construction">CÔNG TRÌNH</Link>
              </div>
              <div className={`nav-item col-md-2 ${style.nav__item}`}>
                <Link to="/under-construction">TIN TỨC</Link>
              </div>
              <div className={`nav-item col-md-2 ${style.nav__item}`}>
                <Link to="/under-construction">GIỚI THIỆU</Link>
              </div>
            </div>
          </nav>
          <div className="col-md-3 d-flex justify-content-center align-items-center">
            <button className={`${style.utility__button} px-2 mx-2`}>
              <i className="bi bi-bell-fill"></i>
            </button>
            <button className={`${style.utility__button} px-2 mx-2`}>
              <i className="bi bi-cart-fill"></i>
            </button>
            <button className={`${style.utility__button} px-2 mx-2`}>
              <i className="bi bi-person-circle"></i>
            </button>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
