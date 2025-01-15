import axiosClient from "./axiosClient";

const END_POINTS = {
  GET_FARM_FISH: "farm-fish/get-all",
};

export const getAllFarmFish = () => {
    return axiosClient.get(`${END_POINTS.GET_FARM_FISH}`);
};