import { Link } from "react-router-dom";
import formatVND from "../utils/formatVND";
import style from "../assets/scss/FishCard.module.scss";

const FishCard = ({ fish }) => {
  return (
    <div className="col-md-3 mb-3 px-2">
      <Link className="text-decoration-none" to={`/fish/${fish.id}`}>
        <div className={`card w-100 overflow-hidden shadow ${style.card}`}>
          <div className={`${style.card__image__container}`}>
            <img
              src={fish.primaryImageUrl}
              className={`card-img-top ${style.card__image}`}
              alt={fish.name}
            />
          </div>
          <div className="card-body">
            <h5 className={`card-title text-start mb-2 ${style.card__title}`}> {fish.code + ` ` + fish.name}</h5>
            <div className="text-start text-danger fw-bold">
              {fish.price ? formatVND(fish.price) : "0"}
            </div>
            <div className="card-text text-start">
              <div>
                <strong>Giới tính:</strong> {fish.gender ? fish.gender : ""}
              </div>
              <div>
                <strong>Năm sinh:</strong> {fish.yob ? fish.yob : ""}
              </div>
              <div>
                <strong>Kích thước:</strong> {fish.size ? fish.size : ""}
              </div>
              <div>
                <strong> Giống cá:</strong> {fish.category ? fish.category : ""}
              </div>
              <div>
                <strong>Trang trại:</strong>{" "}
                {fish.farmName ? fish.farmName : ""}
              </div>
            </div>
          </div>
        </div>
      </Link>
    </div>
  );
};

export default FishCard;
