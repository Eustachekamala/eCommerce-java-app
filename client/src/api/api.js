import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        "Content-Type": "application/json",
    }
})
    //Product API functions
export const getProducts = () => api.get('/products')
export const getProductById = id => api.get(`/products/${id}`)
export const createProduct = (data) => api.post(`/products`, data)
export const deleteProduct = (id) => api.delete(`/products/${id}`)
export const updateProduct = (data) => api.post(`/products/${id}`, data)
    //Category API functions
export const getCategories = () => api.get('/categories')
export const createCategories = data => api.post(`/categories`, data)

    //Payment API functions
export const creatPayment = (paymentData) => api.post("/orders/payment", paymentData)

export const getCurrencies = () => api.get("/currencies");


