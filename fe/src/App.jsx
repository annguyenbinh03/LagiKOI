import { Route, Routes } from "react-router-dom";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";
import "bootstrap-icons/font/bootstrap-icons.css";

import Layout from "./components/Layout";
import Unauthorized from "./components/Unauthorized";
import Login from "./components/Login";
import Missing from "./components/Missing";
import Home from "./components/Home";
import Admin from "./components/Admin";
import FishDetail from "./components/FishDetail";
import RequireAuth from "./components/RequireAuth";
import Order from "./components/Order";
import Profile from "./components/Profile";
import { ToastContainer } from "react-toastify";

const ROLES = {
  'USER' : 'ROLE_USER',
  'MANAGER' : 'ROLE_MANAGER',
  'ADMIN' : 'ROLE_ADMIN',
}

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/fish-detail" element={<FishDetail />} />

          <Route element={<RequireAuth allowedRoles={[ROLES.USER]} />}>
            <Route path="/order" element={<Order />} />
            <Route path="/profile" element={<Profile />} />
          </Route>

          <Route element={<RequireAuth allowedRoles={[ROLES.ADMIN]} />}>
            <Route path="/admin" element={<Admin />} />
          </Route>

          <Route path="/unauthorized" element={<Unauthorized />} />
          <Route path="*" element={<Missing />} />
        </Route>
      </Routes>
      <ToastContainer />
    </>
  );
}

export default App;
