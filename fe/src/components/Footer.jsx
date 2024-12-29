import style from "../assets/scss/Footer.module.scss";

const Footer = () => {
  return (
    <footer className="bg-dark text-white text-center">
      <div className="d-flex justify-content-center">
        <div>
          LAGIKOI 
          <p>
            Địa chỉ: 91 Chương Dương, Phường Linh Chiểu, Thành phố Thủ Đức,
            TP.HCM, Việt Nam
          </p>
          <p>Chịu trách nhiệm Quản lý Nội Dung: AnNguyenBinh</p>
          <p>Mã số doanh nghiệp: chưa cấp </p>
        </div>
        <div>
          Thống kê truy cập
          <p>Truy cập ngày: 0</p>
          <p>Truy cập tuần: 0</p>
          <p>Truy cập tháng: 0</p>
          <p>Tổng lượng truy cập: 0</p>
        </div>
      </div>

      <div className={`${style.copyright} py-2`}>
        Copyright © 2024 LAGI KOI. Design by AnNguyenBinh
      </div>
    </footer>
  );
};

export default Footer;
