import React, { useEffect, useState } from "react";
import { getProducts } from "../api/api";
import { useCart } from "../Context/CartContext.jsx";

function Home() {
    const [products, setProducts] = useState([]);
    const { addToCart } = useCart();

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const res = await getProducts();
                setProducts(res.data);
            } catch (error) {
                console.error("Error fetching products", error);
            }
        };

        fetchProducts();
    }, []);

    return (
        <div className="p-8 bg-gray-50 min-h-screen">
            <h1 className="text-4xl font-bold mb-10 text-center text-gray-800">Our Products</h1>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8">
                {products.map((product) => (
                    <div key={product.productId} className="bg-white rounded-xl shadow-md overflow-hidden hover:shadow-lg transition">
                        {product.imageUrl && (
                            <img
                                src={`http://localhost:8080${product.imageUrl}`}
                                alt={product.productName}
                                className="w-full h-48 object-cover"
                            />
                        )}
                        <div className="p-5">
                            <h2 className="text-2xl font-semibold mb-2 text-gray-800">
                                {product.productName}
                            </h2>
                            <p className="text-lg text-gray-600 mb-4 font-medium">
                                {product.price} {product.currency || '$'}
                            </p>
                            <button
                                onClick={() => addToCart(product)}
                                className="w-full bg-blue-600 hover:bg-blue-700 text-white py-2 px-4 rounded-lg"
                            >
                                Add to Cart
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Home;
