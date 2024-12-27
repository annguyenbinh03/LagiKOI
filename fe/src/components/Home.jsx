import { Link } from "react-router-dom";

const Home = () => {
    return (
        <section>
            <h1>Home</h1>
            <br />
            <Link to="/login">Go to the Login page</Link>
            <br />
            <Link to="/fish-detail">Go to the fish detail page</Link>
            <br />
            <Link to="/order">Go to the order page</Link>
            <br />
            <Link to="/profile">Go to the profile page</Link>
            <br />
            <Link to="/admin">Go to the admin page</Link>
            <br />
            <Link to="/abcxyz">Go to the missing page</Link>
            <br />
            <Link to="/unauthorized">Go to the Unauthorized page</Link>
        </section>
    )
}

export default Home