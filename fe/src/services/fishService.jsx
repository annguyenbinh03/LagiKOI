import axiosClient from "./axiosClient";

const END_POINTS = {
  GET_FISH: "fish/get",
};

export const getFish = (page = 0, size = 8, sortBy = 'id', order = 'desc', name = 'all', gender = 'all', farmName = 'all', categoryName = 'all') => {
    const params = new URLSearchParams();
    params.append('page', page);
    params.append('size', size);
    params.append('sortBy', sortBy);
    params.append('order', order);
    params.append('name', name);
    params.append('gender', gender);
    params.append('farmName', farmName);
    params.append('categoryName', categoryName);
    const url = `${END_POINTS.GET_FISH}?${params.toString()}`;
    return axiosClient.get(url);
};