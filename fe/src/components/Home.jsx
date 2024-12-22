import { Link } from "react-router-dom";

const Home = () => {
    return (
        <section>
            <h1>Home</h1>
            <br />
            <Link to="/Login">Go to the Login page</Link>
            <br />
            <Link to="/admin">Go to the Missing page</Link>
            <br />
            <Link to="/linkpage">Go to the Unauthorized page</Link>
        </section>
    )
}

export default Home