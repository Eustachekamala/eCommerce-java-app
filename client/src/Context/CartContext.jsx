import React, { createContext, useState, useContext } from "react";

const CartContext = createContext(null);

export function CartProvider({ children }) {
    const [cartItems, setCartItems] = useState([]);

    // Add a product to cart
    const addToCart = (product) => {
        setCartItems((prev) => [...prev, product]);
    };

    // Remove a product from cart
    const removeFromCart = (productId) => {
        setCartItems((prev) => prev.filter((item) => item.productId !== productId));
    };

    // Clear the whole cart
    const clearCart = () => {
        setCartItems([]);
    };

    return (
        <CartContext.Provider value={{ cartItems, addToCart, removeFromCart, clearCart }}>
            {children}
        </CartContext.Provider>
    );
}

// Hook to use cart easily
export function useCart() {
    return useContext(CartContext);
}
