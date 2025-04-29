import {useState} from "react";
import {createProduct, getCategories} from "../../api/api.js";

function Dashboard() {
    const [showModal, setShowModal] = useState(false);
    const [productData, setProductData] = useState({
        productName: "",
        price: "",
        stock: "",
        currency: "USD",
        categoryId: "",
    });
    const [categories, setCategories] = useState([]);
    const [imageUrl, setImageUrl] = useState(null);

    const handleOpenModal = async () => {
        const res = await getCategories();
        setCategories(res.data);
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setShowModal(false);
        setProductData({ productName: "", price: "", stock: "" , currency: "USD", categoryId: "" });
        setImageUrl(null);
    };

    const handleInputChange = (e) => {
        setProductData({ ...productData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const formData = new FormData();
        formData.append("product", new Blob([JSON.stringify(productData)], { type: "application/json" }));
        formData.append("image", imageUrl);

        try {
            await createProduct(formData);
            alert("Product uploaded!");
            handleCloseModal();
        } catch (error) {
            console.error("Upload failed", error);
        }
    };

    return (
        <div className="p-6">
            <h1 className="text-3xl font-bold mb-4">Admin Dashboard</h1>
            <button
                onClick={handleOpenModal}
                className="bg-blue-600 text-white px-4 py-2 rounded"
            >
                Add Product
            </button>

            {/* Modal */}
            {showModal && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
                    <div className="bg-white p-6 rounded shadow w-full max-w-md">
                        <h2 className="text-2xl font-semibold mb-4">Upload Product</h2>
                        <form onSubmit={handleSubmit}>
                            <input
                                type="text"
                                name="productName"
                                placeholder="Product Name"
                                className="w-full p-2 mb-3 border"
                                value={productData.productName}
                                onChange={handleInputChange}
                                required
                            />
                            <input
                                type="number"
                                name="price"
                                placeholder="Price"
                                className="w-full p-2 mb-3 border"
                                value={productData.price}
                                onChange={handleInputChange}
                                required
                            />
                            <input
                                type="number"
                                name="stock"
                                placeholder="Stock"
                                className="w-full p-2 mb-3 border"
                                value={productData.stock}
                                onChange={handleInputChange}
                                required
                            />
                            <select
                                name="currency"
                                className="w-full p-2 mb-3 border"
                                value={productData.currency}
                                onChange={handleInputChange}
                            >
                                <option value="USD">USD</option>
                                <option value="KES">KES</option>
                                <option value="EUR">EUR</option>
                            </select>
                            <select
                                name="categoryId"
                                className="w-full p-2 mb-3 border"
                                value={productData.categoryId}
                                onChange={handleInputChange}
                                required
                            >
                                <option value="">Select Category</option>
                                {categories.map(cat => (
                                    <option key={cat.categoryId} value={cat.categoryId}>
                                        {cat.categoryName}
                                    </option>
                                ))}
                            </select>
                            <input
                                type="file"
                                accept="image/*"
                                className="w-full mb-4"
                                onChange={(e) => setImageUrl(e.target.files[0])}
                                required
                            />
                            <div className="flex justify-end">
                                <button type="button" onClick={handleCloseModal} className="mr-2 text-gray-500">
                                    Cancel
                                </button>
                                <button type="submit" className="bg-green-600 text-white px-4 py-2 rounded">
                                    Upload
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            )}
        </div>
    );
}
export default Dashboard;