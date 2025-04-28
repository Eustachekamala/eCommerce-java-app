import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import {CartProvider} from "./Context/CartContext.jsx";
import App from "./router/App.jsx";

createRoot(document.getElementById('root')).render(
  <StrictMode>
      <CartProvider>
          <App/>
      </CartProvider>
  </StrictMode>,
)
