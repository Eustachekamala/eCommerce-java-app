import React from "react";
import { Link } from "react-router-dom";

function NavBar() {
    return (
        <>
            <nav className="bg-blue-700 text-white px-6 py-4 flex justify-between items-center shadow">
                <Link to="/" className="text-2xl font-bold">MyStore</Link>
                <div className="space-x-4">
                    <Link to="/" className="hover:underline">Home</Link>
                    <Link to="/cart" className="hover:underline">Cart</Link>
                    <Link to="/checkout" className="hover:underline">Checkout</Link>
                    <Link to="/admin" className="hover:underline">Admin</Link>
                </div>
            </nav>
        </>
    )
}
export default NavBar