import { Link } from "react-router-dom";
import homeBanner1 from "../assets/images/banners/home-banner1.webp";
import homeBanner2 from "../assets/images/banners/home-banner2.webp";
import homeBanner3 from "../assets/images/banners/home-banner3.webp";
import img1 from "../assets/images/heros/home-hero1.jpg";
import separator from "../assets/images/separators/home-separator.jpg";

import style from "../assets/scss/Home.module.scss";
import { OverlayTrigger, Tooltip } from "react-bootstrap";

const Home = () => {
  return (
    <div className="container-fluid px-0">
      <div className={`block__1`}>
        <div
          className="carousel slide"
          data-bs-ride="carousel"
          data-bs-wrap="true"
        >
          <div className="carousel-inner h-100">
            <div className="carousel-item active" data-bs-interval="3000">
              <img
                src={homeBanner1}
                className="d-block img-fluid"
                alt="LagiKoi home banner"
              />
            </div>
            <div className="carousel-item" data-bs-interval="3000">
              <img
                src={homeBanner2}
                className="d-block img-fluid"
                alt="LagiKoi home banner"
              />
            </div>
            <div className="carousel-item" data-bs-interval="3000">
              <img
                src={homeBanner3}
                className="d-block img-fluid"
                alt="LagiKoi home banner"
              />
            </div>
            <div
              className={`${style.carousel__caption} top-50 start-50 translate-middle`}
            >
              <h1>Chào mừng đến với LagiKoi</h1>
              <OverlayTrigger
                key="a"
                placement="bottom"
                overlay={
                  <Tooltip>Đối tác tin cậy cho vườn cá Koi hoàn hảo</Tooltip>
                }
              >
                <p>完璧な錦鯉の庭の信頼できるパートナー</p>
              </OverlayTrigger>
              <div>
                <button class={`${style.button} mx-2`}>Xem cá Koi mới</button>
                <button class={`${style.button} mx-2`}>Đăng nhập ngay</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className={`block__2 ${style.block__2}`}>
        <div className="container py-5">
          <div className="title">
            <h1 className="fs-1 text-center fw-bold">GIỚI THIỆU</h1>
            <div className={`${style.title__underScore}`}></div>
          </div>
          <div className="row mt-5">
            <div className="col-md-6 pe-3">
              <img
                src={img1}
                className="img-fluid rounded float-end"
                alt="Ảnh cá koi"
              />
            </div>
            <div className="col-md-6 ps-3">
              <p className="fw-bold fs-5">
                LagiKoi là địa chỉ uy tín, chuyên cung cấp các dòng cá koi thuần
                chủng được nhập khẩu trực tiếp từ các trang trại hàng đầu tại
                Nhật Bản.
              </p>
              <p className="fs-5">
                Cá koi không chỉ là biểu tượng của vẻ đẹp tinh tế mà còn đại
                diện cho sự may mắn và thịnh vượng trong phong thủy. Với đội ngũ
                chuyên gia giàu kinh nghiệm và niềm đam mê, chúng tôi lựa chọn
                kỹ lưỡng từng chú cá từ các trang trại nổi tiếng như Marusei,
                Dainichi, Marudo, Sakai,… để đảm bảo đáp ứng mọi yêu cầu của
                khách hàng.
              </p>
              <p className="fs-5">
                Tại LagiKoi, khách hàng không chỉ tìm thấy những chú cá koi độc
                đáo mà còn được hỗ trợ tận tình trong việc thiết kế hồ cá, chọn
                phụ kiện và chăm sóc cá koi. Chúng tôi không ngừng nỗ lực để trở
                thành người bạn đồng hành đáng tin cậy cho cộng đồng yêu thích
                cá koi trên khắp Việt Nam.
              </p>
              <div>
                <button className={`${style.button}`}>
                  <i class="bi bi-eye-fill"></i> Xem thêm
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="separator">
        <img
          src={separator}
          className="img-fluid w-100"
          alt="LagiKoi home page separator"
        />
      </div>
      <div className={`block__3  ${style.block__3}`}>
        <div className="container py-5">
          <div className="title">
            <h1 className="fs-1 text-center fw-bold">CÁ KOI MỚI VỀ</h1>
            <div className={`${style.title__underScore}`}></div>
          </div>
          <div className="row mt-5 text-center">
            <div className="col-md-3">cá koi 1</div>
            <div className="col-md-3">cá koi 2</div>
            <div className="col-md-3">cá koi 3</div>
            <div className="col-md-3">cá koi 4</div>
            <div className="col-md-3">cá koi 5</div>
            <div className="col-md-3">cá koi 6</div>
            <div className="col-md-3">cá koi 7</div>
            <div className="col-md-3">cá koi 8</div>
          </div>
        </div>
        <div className="container py-5">
          <div className="title">
            <h1 className="fs-1 text-center fw-bold">PHỤ KIỆN NỔI BẬT</h1>
            <div className={`${style.title__underScore}`}></div>
          </div>
          <div className="row mt-5 text-center">
            <div className="col-md-3">phụ kiện 1</div>
            <div className="col-md-3">phụ kiện 2</div>
            <div className="col-md-3">phụ kiện 3</div>
            <div className="col-md-3">phụ kiện 4</div>
            <div className="col-md-3">phụ kiện 5</div>
            <div className="col-md-3">phụ kiện 6</div>
            <div className="col-md-3">phụ kiện 7</div>
            <div className="col-md-3">phụ kiện 8</div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
