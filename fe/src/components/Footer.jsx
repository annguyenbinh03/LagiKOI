import style from "../assets/scss/Footer.module.scss";

const Footer = () => {
  return (
    <footer className="bg-dark text-white text-center">
      <div className="container">
        <div className="text-start py-3 row">
          <div className="px-3 col-md-5">
            <p className="fs-4 fw-bold">LAGIKOI</p>
            <p className="fst-italic">
              Địa chỉ: 91 Chương Dương, Phường Linh Chiểu, Thành phố Thủ Đức,
              TP.HCM, Việt Nam
            </p>
            <p className="fst-italic">Mã số doanh nghiệp: chưa cấp </p>
            <p className="fst-italic">Hotline: 0123456789</p>
            <p className="fst-italic">Email: songchozui1@gmail.com</p>
            <p className="fs-4">
              <span className="px-2">
                <i className="bi bi-instagram"></i>
              </span>
              <span className="px-2">
                <i className="bi bi-facebook"></i>
              </span>
              <span className="px-2">
                <i className="bi bi-twitter"></i>
              </span>
            </p>
          </div>
          <div className="px-4 col-md-4 d-flex flex-column pb-3">
            <p className="fs-4 fw-bold">FANPAGE FACEBOOK</p>
            <div className="flex-grow-1">
              <iframe
                src="https://widgets.sociablekit.com/facebook-group-posts/iframe/25503576"
                frameBorder="0"
                width="100%"
                height="100%"
              ></iframe>
            </div>
          </div>
          <div className="px-3 col-md-3">
            <p className="fs-4 fw-bold">THỐNG KÊ TRUY CẬP</p>
            <p className="fs-6 lh-1">Truy cập ngày: 0</p>
            <p className="fs-6 lh-1">Truy cập tuần: 0</p>
            <p className="fs-6 lh-1">Truy cập tháng: 0</p>
            <p className="fs-6 lh-1">Tổng lượng truy cập: 0</p>
          </div>
        </div>
      </div>

      <div className={`${style.copyright} py-3`}>
        Copyright © 2024 LAGI KOI. Design by AnNguyenBinh
      </div>
    </footer>
  );
};

export default Footer;
