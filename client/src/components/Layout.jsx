import React from "react";
import { Link, Outlet } from "react-router-dom";
import NavBar from "./NavBar.jsx";

function Layout() {
    return (
        <div className="min-h-screen flex flex-col">
            {/* Navbar */}
            <NavBar/>
            {/* Main content */}
            <main className="flex-1 p-6 bg-gray-50">
                <Outlet />
            </main>

            {/* Footer (optional) */}
            <footer className="bg-blue-700 text-white text-center py-3">
                &copy; {new Date().getFullYear()} MyStore. All rights reserved.
            </footer>
        </div>
    );
}

export default Layout;
