package com.eustachecode.eCommerce_java_app.controllers;

import com.eustachecode.eCommerce_java_app.models.Currency;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
    @GetMapping
    public Currency[] getAllCurrencies() {
        return Currency.values();
    }
}
