import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
    // headers: {
    //     "Content-Type": "application/json",
    // }
});

// ------------------- Product API -------------------
export const getProducts = () => api.get('/products');
export const getProductById = (id) => api.get(`/products/${id}`);
export const createProduct = (data) => api.post(`/products`, data);
export const updateProduct = (id, data) => api.put(`/products/${id}`, data);
export const deleteProduct = (id) => api.delete(`/products/${id}`);

// ✅ Upload product with image
export const uploadProductWithImage = (productData, selectedFile) => {
    const formData = new FormData();
    formData.append("product", new Blob([JSON.stringify(productData)], { type: "application/json" }));
    formData.append("image", selectedFile);

    return api.post("/products/upload", formData, {
        headers: { "Content-Type": "multipart/form-data" }
    });
};

// ------------------- Category API -------------------
export const getCategories = () => api.get('/categories');
export const createCategories = (data) => api.post(`/categories`, data);

// ------------------- Payment API -------------------
export const creatPayment = (paymentData) => api.post("/orders/payment", paymentData);

// ------------------- Currency API -------------------
export const getCurrencies = () => api.get("/currencies");
