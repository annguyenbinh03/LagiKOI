import axiosClient from "./axiosClient";

const END_POINTS = {
  GET_FISH: "fish/get",
};

export const getFish = (page = 0, size = 8, sortBy = 'id', order = 'desc') => {
    const params = new URLSearchParams();
    params.append('page', page);
    params.append('size', size);
    params.append('sortBy', sortBy);
    params.append('order', order);
    const url = `${END_POINTS.GET_FISH}?${params.toString()}`;
    return axiosClient.get(url);
};