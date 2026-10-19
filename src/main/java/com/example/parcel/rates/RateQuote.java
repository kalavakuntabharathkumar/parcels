package com.example.parcel.rates;
import java.math.BigDecimal;
public record RateQuote(String quoteId, String serviceLevel, BigDecimal baseAmount,
                        BigDecimal fuelSurcharge, BigDecimal totalAmount, String currency) {}
