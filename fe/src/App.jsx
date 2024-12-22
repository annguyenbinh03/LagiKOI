import { Route, Routes } from "react-router-dom";
import "./App.css";

import Layout from "./components/Layout";
import Unauthorized from "./components/Unauthorized";
import Login from "./components/Login";
import Missing from "./components/Missing";
import Home from "./components/Home";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route path="/" element={<Home />} />

        <Route path="login" element={<Login />} />

        <Route path="/unauthorized" element={<Unauthorized />} />

        <Route path="*" element={<Missing />} />
      </Route>
    </Routes>
  );
}

export default App;
