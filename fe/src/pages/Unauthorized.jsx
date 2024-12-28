import { Link } from "react-router-dom";

const Unauthorized = () => {
  return (
    <div>
      Unauthorized
      <div>
        <Link to="/">Visit Our Homepage</Link>
      </div>
    </div>
  );
};

export default Unauthorized;
