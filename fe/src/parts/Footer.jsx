const Footer = () => {
  return (
    <footer className="bg-dark text-white text-center py-3">
      <div className="container">
        <p>&copy; 2024 My Website. All rights reserved.</p>
        <ul className="list-inline">
          <li className="list-inline-item">
            <a href="#" className="text-white text-decoration-none">
              Privacy Policy
            </a>
          </li>
          <li className="list-inline-item">
            <a href="#" className="text-white text-decoration-none">
              Terms of Service
            </a>
          </li>
        </ul>
      </div>
    </footer>
  );
};

export default Footer;
