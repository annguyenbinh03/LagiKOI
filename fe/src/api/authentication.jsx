import axiosClient from './axiosClient'

const END_POINTS = {
    GET_TOKEN: "auth/token"
}
  
export const getToken = ( username, password ) => {
    return axiosClient.post(`${END_POINTS.GET_TOKEN}`, {username, password});
};
  