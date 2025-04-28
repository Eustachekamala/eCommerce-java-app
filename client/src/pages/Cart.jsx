import React from "react";
import {useCart} from "../Context/CartContext.jsx";

function Cart() {
    const { cartItems, removeFromCart, clearCart } = useCart();

    const totalPrice = cartItems.reduce((acc, item) => acc + item.price * item.quantity, 0);

    return (
        <div className="p-8">
            <h1 className="text-3xl font-bold mb-6">Your Cart</h1>

            {cartItems.length === 0 ? (
                <p className="text-gray-500">Your cart is empty.</p>
            ) : (
                <div className="space-y-6">
                    {cartItems.map((item) => (
                        <div key={item.productId} className="flex items-center justify-between border-b pb-4">
                            <div>
                                <h2 className="text-xl font-semibold">{item.name}</h2>
                                <p className="text-gray-600">Qty: {item.quantity}</p>
                                <p className="text-gray-600">
                                    Price: {item.price} {item.currency}
                                </p>
                            </div>
                            <button
                                onClick={() => removeFromCart(item.productId)}
                                className="bg-red-600 text-white px-3 py-1 rounded hover:bg-red-700"
                            >
                                Remove
                            </button>
                        </div>
                    ))}

                    <div className="mt-6">
                        <h2 className="text-2xl font-bold">Total: {totalPrice.toFixed(2)}</h2>
                        <button
                            onClick={clearCart}
                            className="bg-gray-700 text-white px-4 py-2 rounded hover:bg-gray-800 mt-4"
                        >
                            Clear Cart
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
}

export default Cart;
