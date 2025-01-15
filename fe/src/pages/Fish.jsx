import { useState } from "react";
import { getFish } from "../services/fishService";
import Loading from "../components/Loading";
import FishCard from "../components/FishCard";
import style from "../assets/scss/Fish.module.scss";
import FilterDropdown from "../components/FilterDropdown";

import { getAllFarmFish } from "../services/farmFishService";
import { getAllFishCategory } from "../services/fishCategoryService";
import OrderDropdown from "../components/OrderDropdown";

const FISH_GENDER = [
  {
    name: "Đực",
    value: "male",
  },
  {
    name: "Cái",
    value: "female",
  },
];

const ORDER_BY = [
  {
    name: "Mới nhất",
    sortBy: "product.createdAt",
    order: "desc",
  },
  {
    name: "Cũ nhất",
    sortBy: "product.createdAt",
    order: "asc",
  },
  {
    name: "Giá giảm dần",
    sortBy: "product.price",
    order: "desc",
  },
  {
    name: "Giá tăng dần",
    sortBy: "product.price",
    order: "asc",
  },
];

const Fish = () => {
  const [fishLoading, setFishLoading] = useState(true);
  const [categoryLoading, setCategoryLoading] = useState(true);
  const [farmFishLoading, setFarmFishLoading] = useState(true);

  const [page, setPage] = useState(0);
  const [pageSize, setPageSize] = useState(8);
  const [sortBy, setSortBy] = useState(null);

  const [categoryList, setCategoryList] = useState([]);
  const [farmList, setFarmFish] = useState([]);

  const [fish, setFish] = useState({});
  const [name, setName] = useState("");
  const [category, setCategory] = useState(null);
  const [gender, setGender] = useState(null);
  const [farm, setFarm] = useState(null);
  const [order, setOrder] = useState(ORDER_BY[0]);

  const fetchFarmFish = async () => {
    try {
      const response = await getAllFarmFish();
      console.log(response);
      setFarmFish(response.result);
    } catch (error) {
      console.error("Failed to fetch fish data:", error);
      setFish([]);
    } finally {
      setFarmFishLoading(false);
    }
  };

  const fetchFishData = async () => {
    setFishLoading(true);
    try {
      const response = await getFish(
        page,
        pageSize,
        sortBy ? sortBy : "product.createdAt",
        order ? order : "desc",
        name !== "" ? name : "all",
        gender?.value ? gender.value : "all",
        farm ? farm.name : "all",
        category ? category.name : "all"
      );
      console.log(response);
      setFish(response.result);
    } catch (error) {
      console.error("Failed to fetch fish data:", error);
      setFish([]);
    } finally {
      setTimeout(() => {
        setFishLoading(false);
      }, 200);

    }
  };

  const fetchFishCategories = async () => {
    try {
      const response = await getAllFishCategory();
      console.log(response);
      setCategoryList(response.result);
    } catch (error) {
      console.error("Failed to fetch fish data:", error);
      setCategoryList([]);
    } finally {
      setCategoryLoading(false);
    }
  };

  const handleClickFilterButton = () => {
    fetchFishData();
  };

  const handleOnChange = (event) =>{
      setName(event.target.value);
  }

  useState(() => {
    fetchFarmFish();
    fetchFishCategories();
    fetchFishData();
  }, []);

  return (
    <>
      <div className={`title ${style.title}`}>
        <h1 className="fs-1 text-center py-3 fw-bold">CÁ KOI</h1>
      </div>
      <div className="container bg-white">
        <div className="search-form pb-2 bg-secondary-subtle px-3 py-3">
          <div className="row mb-3">
            <div className="col-md-3">
              <input
              onChange={handleOnChange}
                className="form-control w-100 h-100 bg-white border-secondary-subtle"
                placeholder="Lọc theo tên"
                value={name}
              />
            </div>
            <div className="col-md-3">
              <FilterDropdown
                selectedItems={category}
                setSelectedItem={setCategory}
                placeHolder={"Chọn giống cá"}
                items={categoryList}
              />
            </div>
            <div className="col-md-3">
              <FilterDropdown
                selectedItems={gender}
                setSelectedItem={setGender}
                placeHolder={"Chọn giới tính"}
                items={FISH_GENDER}
              />
            </div>
            <div className="col-md-3">
              <FilterDropdown
                selectedItems={farm}
                setSelectedItem={setFarm}
                placeHolder={"Chọn trang trại"}
                items={farmList}
              />
            </div>
          </div>
          <div className="row d-flex justify-content-start">
            <div className="col-md-3">
              <OrderDropdown
                items={ORDER_BY}
                setSortBy={setSortBy}
                setOrder={setOrder}
              />
            </div>
            <div className="col-md-3">
              <button
                type="button"
                onClick={handleClickFilterButton}
                className="btn btn-secondary"
              >
                Lọc danh sách
              </button>
            </div>
          </div>
        </div>
        <div className=" px-5 pt-4 text-center" style={{ minHeight: "800px" }}>
          {fishLoading ? (
            <Loading />
          ) : (
            <div className={`row`}>
              {fish?.map((item) => {
                return <FishCard key={item.id} fish={item} />;
              })}
            </div>
          )}
        </div>
      </div>
    </>
  );
};

export default Fish;
