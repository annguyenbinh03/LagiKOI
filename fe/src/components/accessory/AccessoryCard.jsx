import { Link } from "react-router-dom";
import formatVND from "../../utils/formatVND";
import style from "../../assets/scss/AccessoryCard.module.scss";
import AccessoryCardHighlight from "./AccessoryCardHighlight";

const AccessoryCard = ({ accessory }) => {
  return (
    <div className="col-md-3 mb-3 px-2">
      <Link className="text-decoration-none" to={`/accessory/${accessory.id}`}>
        <div className={`card w-100 overflow-hidden shadow ${style.card}`}>
          <div className={`${style.card__image__container}`}>
            <img
              src={accessory.primaryImageUrl}
              className={`card-img-top ${style.card__image}`}
              alt={accessory.name}
            />
          </div>
          <div className="card-body">
            <h5 className={`card-title text-start mb-2 ${style.card__title}`}>
              {accessory.name}
            </h5>
            <div className="text-start text-danger fw-bold">
              {accessory.price ? formatVND(accessory.price) : "0"}
            </div>
            <div className="card-text text-start">
              <div>
                <strong>Thương hiệu:</strong>{" "}
                {accessory.brand ? accessory.brand : ""}
              </div>
              <div>
                <strong>Loại sản phẩm:</strong>{" "}
                {accessory.category ? accessory.category : ""}
              </div>
              <AccessoryCardHighlight accessory={accessory} />
            </div>
          </div>
        </div>
      </Link>
    </div>
  );
};

export default AccessoryCard;
