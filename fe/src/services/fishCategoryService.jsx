import axiosClient from "./axiosClient"

const END_POINTS = {
    GET_ALL: "/fish-category/get-all",
}

export const getAllFishCategory = () =>{
    return axiosClient.get(`${END_POINTS.GET_ALL}`);
}