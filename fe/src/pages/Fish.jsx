import { useEffect, useState } from "react";
import Loading from "../components/Loading";
import FishCard from "../components/FishCard";
import style from "../assets/scss/Fish.module.scss";
import FilterDropdown from "../components/FilterDropdown";
import { Pagination } from "react-bootstrap";

import { getFish, getTotalFish } from "../services/fishService";
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
  const [totalFishLoading, setTotalFishLoading] = useState(true);

  const [page, setPage] = useState(1);
  const [pageCount, setPageCount] = useState(0);
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

  const fetchTotalFish = async () => {
    try {
      const response = await getTotalFish();
      console.log(response);
      setPageCount(Math.ceil(response.result / pageSize));
    } catch (error) {
      console.error("Failed to fetch fish data:", error);
    } finally {
      setTotalFishLoading(false);
    }
  };

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
        page - 1,
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

  const handleOnChange = (event) => {
    setName(event.target.value);
  };

  const handlePageClick = (pageNumber) => {
    setPage(pageNumber);
  };

  const renderPaginationItems = () => {
    const items = [];
    const maxPagesToShow = 5;
    const startPage = Math.max(1, page - Math.floor(maxPagesToShow / 2));
    const endPage = Math.min(pageCount, page + Math.floor(maxPagesToShow / 2));
    if (startPage > 1) {
      items.push(
        <Pagination.Item key={1} active={page === 1} onClick={() => handlePageClick(1)}>
          1
        </Pagination.Item>
      );
  
      if (startPage > 2) {
        items.push(<Pagination.Ellipsis key="start-ellipsis" disabled />);
      }
    }
    for (let i = startPage; i <= endPage; i++) {
      items.push(
        <Pagination.Item key={i} active={i === page} onClick={() => handlePageClick(i)}>
          {i}
        </Pagination.Item>
      );
    }
    if (endPage < pageCount) {
      if (endPage < pageCount - 1) {
        items.push(<Pagination.Ellipsis key="end-ellipsis" disabled />);
      }
  
      items.push(
        <Pagination.Item key={pageCount} active={page === pageCount} onClick={() => handlePageClick(pageCount)}>
          {pageCount}
        </Pagination.Item>
      );
    }
    return items;
  };

  useEffect(() => {
    fetchFishData();
    fetchTotalFish();
  }, [page, pageSize, sortBy, order, name, gender, farm, category]);

  useState(() => {
    fetchTotalFish();
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
        <div className="search-form bg-secondary-subtle px-3 py-3 rounded">
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
        <div className="d-flex justify-content-center">
          <Pagination >
            <Pagination.Prev
              onClick={() => page > 1 && handlePageClick(page - 1)}
            />
            {renderPaginationItems()}
            <Pagination.Next
              onClick={() => page < pageCount && handlePageClick(page + 1)}
            />
          </Pagination>
        </div>
      </div>
    </>
  );
};

export default Fish;
