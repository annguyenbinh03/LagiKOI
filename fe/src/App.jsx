import { Route, Routes } from "react-router-dom";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";
import "bootstrap-icons/font/bootstrap-icons.css";

import Unauthorized from "./pages/Unauthorized";
import Login from "./pages/Login";
import Missing from "./pages/Missing";
import Home from "./pages/Home";
import Admin from "./pages/Admin";
import FishDetail from "./pages/FishDetail";
import RequireAuth from "./components/RequireAuth";
import Order from "./pages/Order";
import Profile from "./pages/Profile";
import { ToastContainer } from "react-toastify";
import UserLayout from "./components/UserLayout";
import ManagerLayout from "./components/ManagerLayout";

const ROLES = {
  USER: "ROLE_USER",
  MANAGER: "ROLE_MANAGER",
  ADMIN: "ROLE_ADMIN",
};

function App() {
  return (
    <>
      <main className="App">
        <Routes>
          <Route path="/" element={<UserLayout />}>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/fish-detail" element={<FishDetail />} />

            <Route element={<RequireAuth allowedRoles={[ROLES.USER]} />}>
              <Route path="/order" element={<Order />} />
              <Route path="/profile" element={<Profile />} />
            </Route>
          </Route>
          <Route element={<RequireAuth allowedRoles={[ROLES.ADMIN]} />}>
            <Route path="/admin" element={<ManagerLayout />}>
              <Route index element={<Admin />} />
            </Route>
          </Route>
          <Route path="/unauthorized" element={<Unauthorized />} />
          <Route path="*" element={<Missing />} />
        </Routes>
      </main>
      <ToastContainer />
    </>
  );
}

export default App;
