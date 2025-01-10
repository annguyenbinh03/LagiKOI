import { useState } from "react";
import { getFish } from "../services/fishService";
import Loading from "../components/Loading";
import FishCard from "../components/FishCard";
import style from "../assets/scss/Fish.module.scss";
import FilterDropdown from "../components/FilterDropdown";

import { getAllFishCategory } from "../services/fishCategoryService";
import OrderDropdown from "../components/OrderDropdown";

const FISH_GENDER= [
  {
    name: "Đực",
    value: "male"
  },
  {
    name: "Cái",
    value: "female"
  },
];

const FARMS = [
  {
    name: "Hiroi Koi Farm",
  },
  {
    name: "Maruhide Koi Farm",
  },
  {
    name: "Hiroi Koi Farm",
  },
];

const ORDER_BY= [
  {
    name: "Mới nhất",
    value: "newest"
  },
  {
    name: "Cũ nhất",
    value: "oldest"
  },
  {
    name: "Giá giảm dần",
    value: "priceDesc"
  },
  {
    name: "Giá tăng dần",
    value: "priceAsc"
  }
]

const Fish = () => {
  const [fishLoading, setFishLoading] = useState(true);
  const [categoryLoading, setCategoryLoading] = useState(true);

  const [page, setPage] = useState(0);
  const [pageSize, setPageSize] = useState(8);
  const [sortBy, setSortBy] = useState(null);
  
  const [categoryList, setCategoryList] = useState([]);

  const [fish, setFish] = useState({});
  const [name, setName] = useState('');
  const [category, setCategory] = useState(null);
  const [gender, setGender] = useState(null);
  const [farm, setFarm] = useState(null);
  const [order, setOrder] = useState(null);

  const fetchFishData = async () => {
    try {
      const response = await getFish(page, pageSize, 
                                sortBy ? sortBy : 'id', 
                                order ? order : 'desc', 
                                name !== '' ? name : 'all', 
                                gender?.value ? gender.value : 'all', 
                                farm ? farm : 'all', 
                                category ? category : 'all');
      console.log(response);
      setFish(response.result);
    } catch (error) {
      console.error("Failed to fetch fish data:", error);
      setFish([]);
    } finally {
      setFishLoading(false);
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
  useState(() => {
    fetchFishData();
    fetchFishCategories();
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
                className="form-control w-100 h-100 bg-white border-secondary-subtle"
                placeholder="Lọc theo tên"
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
                items={FARMS}
              />
            </div>
          </div>
          <div className="row d-flex justify-content-start">
            <div className="col-md-3">
              <OrderDropdown
                selectedItems={order}
                setSelectedItem={setOrder}
                items={ORDER_BY}
              />
            </div>
            <div className="col-md-3">
              <button type="button" class="btn btn-secondary">
                Lọc danh sách
              </button>
            </div>
          </div>
        </div>
        {fishLoading ? (
          <Loading />
        ) : (
          <div className="row px-5 pt-4 text-center">
            {fish?.map((item) => {
              return <FishCard key={item.id} fish={item} />;
            })}
          </div>
        )}
      </div>
    </>
  );
};

export default Fish;
