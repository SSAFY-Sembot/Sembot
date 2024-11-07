import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { useAuthenticate } from "@app/hooks";

export const PrivateRoute = (): React.ReactElement => {
	return useAuthenticate() ? <Outlet /> : <Navigate to="/" />;
};
