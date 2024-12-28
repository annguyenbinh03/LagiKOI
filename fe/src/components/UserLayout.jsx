import { Outlet } from "react-router-dom";
import Header from "../parts/Header";
import Footer from "../parts/Footer";

const UserLayout = () => {
  return (
    <div>
      <Header />
      <main>
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};

export default UserLayout;
