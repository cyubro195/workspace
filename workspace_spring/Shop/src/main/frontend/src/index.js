import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from 'react-router-dom';
import { CheckoutPage } from "./pages/Checkout"
import { createBrowserRouter, RouterProvider } from "react-router-dom"

const router = createBrowserRouter([
  {
    path: "/",
    element: <CheckoutPage />,
  },
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
      {/* <React.StrictMode> */}
        <RouterProvider router={router} />
        {/* <App /> */}
      {/* </React.StrictMode> */}
    </BrowserRouter>
);


reportWebVitals();
