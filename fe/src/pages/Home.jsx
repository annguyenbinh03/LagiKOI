import { Link } from "react-router-dom";
import homeBanner1 from "../assets/images/banners/home-banner1.webp";
import homeBanner2 from "../assets/images/banners/home-banner2.webp";
import homeBanner3 from "../assets/images/banners/home-banner3.webp";
import img1 from "../assets/images/heros/home-hero1.jpg";
import img2 from "../assets/images/heros/home-hero2.jpg";
import eimiFukada from "../assets/images/customers/Eimi-Fukada.jpg";
import mariaOzawa from "../assets/images/customers/Maria-Ozawa.jpg";
import mikamiYua from "../assets/images/customers/Mikami-Yua.jpg";
import minamiAizawa from "../assets/images/customers/Minami-Aizawa.jpg";
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
                <Link className={`d-inline-block ${style.button} mx-2`}>
                  Xem cá Koi mới
                </Link>
                <Link className={`d-inline-block ${style.button} mx-2`}>
                  Đăng nhập ngay
                </Link>
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
                  <i className="bi bi-eye-fill"></i> Xem thêm
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
        <div className="container py-5">
          <div className="title">
            <h1 className="fs-1 text-center fw-bold">THI CÔNG HỒ CÁ</h1>
            <div className={`${style.title__underScore}`}></div>
          </div>
          <div className="row mt-5 text-center">
            <div className="col-md-3">mô hình 1</div>
            <div className="col-md-3">mô hình 2</div>
            <div className="col-md-3">mô hình 3</div>
            <div className="col-md-3">mô hình 4</div>
          </div>
        </div>
      </div>
      <div className={`block__4 ${style.block__4}`}>
        <div className="container py-5 text-white">
          <div className="title">
            <h1 className="fs-1 text-center fw-bold">
              KHÁCH HÀNG NÓI GÌ VỀ CHÚNG TÔI
            </h1>
            <div className={`${style.title__underScore}`}></div>
          </div>
          <div className="row mt-5">
            <div className="col-md-6 ps-4">
              <img
                src={img2}
                style={{ maxWidth: "550px" }}
                className="img-fluid rounded float-end"
                alt="Ảnh cá koi dưới ánh trăng"
              />
            </div>
            <div className="col-md-6 d-flex align-items-center">
              <div id="customer-feedback__carousel" className="carousel slide">
                <div className="carousel-indicators">
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="0"
                    className="active"
                    aria-current="true"
                    aria-label="Slide 1"
                  ></button>
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="1"
                    aria-label="Slide 2"
                  ></button>
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="2"
                    aria-label="Slide 3"
                  ></button>
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="3"
                    aria-label="Slide 4"
                  ></button>
                </div>
                <div className="carousel-inner">
                  <div
                    className={`carousel-item ${style.customerFeedback__carousel__item} active`}
                  >
                    <div className="d-flex justify-content-center align-items-center flex-column">
                      <div>
                        <div className="d-flex justify-content-center">
                          <img
                            width={"100px"}
                            className="shadow-lg border border-3 rounded-circle"
                            src={mikamiYua}
                            alt="Mikami Yua đánh giá cho LagiKoi"
                          />
                        </div>

                        <p className="mb-0 fs-4 fw-bold">Mikami Yua</p>
                        <div className="d-flex justify-content-center">
                          <p className="text-warning mb-2">
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                          </p>
                        </div>
                      </div>
                      <div className="px-5">
                        <p className="px-5 text-center">
                          “Tôi được một người bạn giới thiệu về LagiKoi, và quả
                          thật công ty đã không làm tôi thất vọng. Các chú cá
                          Koi ở đây không chỉ khỏe mạnh mà còn có nhiều chủng
                          loại để lựa chọn. Đặc biệt, nhân viên công ty đã hỗ
                          trợ tôi rất nhiều trong việc chăm sóc cá và bố trí hồ
                          sao cho phù hợp. Tôi rất hài lòng và chắc chắn sẽ giới
                          thiệu LagiKoi đến bạn bè.”
                        </p>
                      </div>
                    </div>
                  </div>
                  <div
                    className={`carousel-item ${style.customerFeedback__carousel__item}`}
                  >
                    <div className="d-flex justify-content-center align-items-center flex-column">
                      <div>
                        <div className="d-flex justify-content-center">
                          <img
                            width={"100px"}
                            className="shadow-lg border border-3 rounded-circle"
                            src={mariaOzawa}
                            alt="Maria Ozawa đánh giá cho LagiKoi"
                          />
                        </div>

                        <p className="mb-0 fs-4 fw-bold">Maria Ozawa</p>
                        <div className="d-flex justify-content-center">
                          <p className="text-warning mb-2">
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                          </p>
                        </div>
                      </div>
                      <div className="px-5">
                        <p className="px-5 text-center">
                          “Ban đầu tôi hơi bối rối trong việc chọn mua cá Koi vì
                          không có nhiều kinh nghiệm. Nhưng nhờ sự hướng dẫn tận
                          tâm từ đội ngũ LagiKoi, tôi đã chọn được những chú cá
                          ưng ý nhất. Bây giờ hồ cá của tôi rất đẹp và hài hòa,
                          mang lại cảm giác thư giãn mỗi khi ngắm nhìn. LagiKoi
                          thực sự là nơi đáng tin cậy khi chọn mua cá Koi.”
                        </p>
                      </div>
                    </div>
                  </div>
                  <div
                    className={`carousel-item ${style.customerFeedback__carousel__item}`}
                  >
                    <div className="d-flex justify-content-center align-items-center flex-column">
                      <div>
                        <div className="d-flex justify-content-center">
                          <img
                            width={"100px"}
                            className="shadow-lg border border-3 rounded-circle"
                            src={minamiAizawa}
                            alt="Minami Aizawa đánh giá cho LagiKoi"
                          />
                        </div>

                        <p className="mb-0 fs-4 fw-bold">Minami Aizawa</p>
                        <div className="d-flex justify-content-center">
                          <p className="text-warning mb-2">
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                          </p>
                        </div>
                      </div>
                      <div className="px-5">
                        <p className="px-5 text-center">
                          “Tôi đã tìm hiểu về cá Koi rất lâu trước khi quyết
                          định đến LagiKoi, và tôi rất vui vì đã chọn đúng nơi.
                          Các chú cá ở đây rất chất lượng, khỏe mạnh và có nhiều
                          kích thước, màu sắc khác nhau để lựa chọn. Nhân viên
                          công ty thì rất thân thiện và hỗ trợ nhiệt tình.
                          LagiKoi đã giúp tôi hoàn thiện hồ cá Koi mà tôi hằng
                          mong ước.”
                        </p>
                      </div>
                    </div>
                  </div>
                  <div
                    className={`carousel-item ${style.customerFeedback__carousel__item}`}
                  >
                    <div className="d-flex justify-content-center align-items-center flex-column">
                      <div>
                        <div className="d-flex justify-content-center">
                          <img
                            width={"100px"}
                            className="shadow-lg border border-3 rounded-circle"
                            src={eimiFukada}
                            alt="Eimi Fukada  đánh giá cho LagiKoi"
                          />
                        </div>

                        <p className="mb-0 fs-4 fw-bold">Eimi Fukada</p>
                        <div className="d-flex justify-content-center">
                          <p className="text-warning mb-2">
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                            <i className="bi bi-star-fill"></i>
                          </p>
                        </div>
                      </div>
                      <div className="px-5">
                        <p className="px-5 text-center">
                          “Tôi biết đến LagiKoi thông qua một sự kiện triển lãm
                          cá cảnh, và thật sự rất ấn tượng với các dòng cá tại
                          đây. Các chú cá không chỉ khỏe mạnh mà còn rất đẹp,
                          màu sắc rực rỡ. Đội ngũ nhân viên của công ty tư vấn
                          rất tận tình, giúp tôi thiết kế và chăm sóc hồ cá một
                          cách chuyên nghiệp. Tôi cảm thấy rất hài lòng và sẽ
                          tiếp tục ủng hộ LagiKoi trong tương lai.”
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                <button
                  className="carousel-control-prev"
                  type="button"
                  data-bs-target="#customer-feedback__carousel"
                  data-bs-slide="prev"
                >
                  <span
                    className="carousel-control-prev-icon"
                    aria-hidden="true"
                  ></span>
                  <span className="visually-hidden">Previous</span>
                </button>
                <button
                  className="carousel-control-next"
                  type="button"
                  data-bs-target="#customer-feedback__carousel"
                  data-bs-slide="next"
                >
                  <span
                    className="carousel-control-next-icon"
                    aria-hidden="true"
                  ></span>
                  <span className="visually-hidden">Next</span>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className={`block__5 ${style.block__5}`}>
        <div className="container py-5">
          <div className="title">
            <h1 className="fs-1 text-center fw-bold">TIN TỨC MỚI</h1>
            <div className={`${style.title__underScore}`}></div>
          </div>
          <div className="row mt-5 text-center">
            <div className="col-md-4">tin tuc 1</div>
            <div className="col-md-4">tin tuc 2</div>
            <div className="col-md-4">tin tuc 3</div>
          </div>
          <div className="row mt-5">
            <div className="d-flex justify-content-center">
              <Link className={`d-inline-block ${style.button} mx-2`}>
                <i className="bi bi-eye-fill"></i> Xem thêm
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
