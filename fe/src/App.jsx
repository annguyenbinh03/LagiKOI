import { Route, Routes } from "react-router-dom";
import "./App.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap-icons/font/bootstrap-icons.css';

import Layout from "./components/Layout";
import Unauthorized from "./components/Unauthorized";
import Login from "./components/Login";
import Missing from "./components/Missing";
import Home from "./components/Home";
import Admin from "./components/Admin";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route path="/" element={<Home />} />

        <Route path="login" element={<Login />} />

        <Route path="/admin" element={<Admin />} />

        <Route path="/unauthorized" element={<Unauthorized />} />

        <Route path="*" element={<Missing />} />
      </Route>
    </Routes>
  );
}

export default App;
