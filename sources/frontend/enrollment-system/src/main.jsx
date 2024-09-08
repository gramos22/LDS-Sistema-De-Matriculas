import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css";

// configuring react router
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import Dashboard from "./Routes/Dashboard";
import SignIn from "./Routes/SignIn";

const router = createBrowserRouter([
  {
    path: "/",
    element: <SignIn />,
  },
  {
    path: "/dashboard",
    element: <Dashboard />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
