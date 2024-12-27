import { jwtDecode } from "jwt-decode";
import { createContext, useEffect, useState } from "react";
import { refreshAccessToken } from "../api/authentication";

const AuthContext = createContext({});

export default AuthContext;

export const AuthProvider = ({ children }) => {
  const [auth, setAuth] = useState({});

  useEffect(() => {
    getStoragedToken();
  }, []);

  const getRoles = (scopes) => {
    let roles = [];
    scopes.forEach((item) => {
      if (item.startsWith("ROLE_")) roles.push(item);
    });
    return roles;
  };

  const getAuthorities = (scopes) => {
    let authorities = [];
    scopes.forEach((item) => {
      if (!item.startsWith("ROLE_")) authorities.push(item);
    });
    return authorities;
  };

  const isExpiredToken = (token) => {
    const decoded = jwtDecode(token);
    console.log("exp: ",decoded.exp * 1000, " now:", Date.now() )
    return decoded.exp * 1000 < Date.now();
  };

  const refreshToken = async (oldAccessToken) => {
    try {
      console.log("expried token");
      const response = await refreshAccessToken(oldAccessToken);
      const refreshedToken = response.result.token;
      localStorage.setItem("lagikoiToken", refreshedToken);
      console.log("new token: ", response);
      return refreshedToken;
    } catch (error) {
      console.error("Error refreshing token:", error);
      localStorage.removeItem("lagikoiToken");
      throw new Error("Failed to refresh token");
    }
  };

  const getStoragedToken = async () => {
    let storagedToken = localStorage.getItem("lagikoiToken");
    console.log(storagedToken);
    if (storagedToken) {
      try {
        if (isExpiredToken(storagedToken))
          storagedToken = await refreshToken(storagedToken);
        const decoded = jwtDecode(storagedToken);
        console.log(decoded);
        const scopeArray = decoded.scope.split(" ");
        const roles = getRoles(scopeArray);
        const authorities = getAuthorities(scopeArray);
        const username = decoded.sub;
        setAuth({ username, roles, authorities, storagedToken });
      } catch (error) {
        console.error("Error refreshing token:", error);
        localStorage.removeItem("lagikoiToken");
      }
    }
  };

  return (
    <AuthContext.Provider value={{ auth, setAuth }}>
      {children}
    </AuthContext.Provider>
  );
};