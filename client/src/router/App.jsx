import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from "../pages/Home";
import CategoryPage from "../pages/CategoryPage";
import CartPage from "../pages/Cart.jsx";
import CheckoutPage from "../pages/CheckoutPage";
import Dashboard from "../pages/admin/Dashboard";

export default function App() {
    return (
        <RouterProvider
            router={createBrowserRouter([
                {
                    path: "/",
                    element: <Home />,
                },
                {
                    path: "/category",
                    element: <CategoryPage />,
                },
                {
                    path: "/cart",
                    element: <CartPage />,
                },
                {
                    path: "/checkout",
                    element: <CheckoutPage />,
                },
                {
                    path: "/admin/dashboard",
                    element: <Dashboard />,
                },
            ])}
        />
    )
}
