package com.example.parcel.rates;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
@Service
public class RateService {
    public RateQuote quote(RateRequest request) {
        BigDecimal weight = BigDecimal.valueOf(request.weightKg());
        BigDecimal multiplier = switch (request.serviceLevel().toUpperCase()) {
            case "EXPRESS" -> new BigDecimal("2.10");
            case "ECONOMY" -> new BigDecimal("0.80");
            default -> BigDecimal.ONE;
        };
        BigDecimal base = new BigDecimal("4.50").add(weight.multiply(new BigDecimal("1.35"))).multiply(multiplier);
        base = base.setScale(2, RoundingMode.HALF_UP);
        BigDecimal fuel = base.multiply(new BigDecimal("0.12")).setScale(2, RoundingMode.HALF_UP);
        return new RateQuote(UUID.randomUUID().toString(), request.serviceLevel().toUpperCase(),
                base, fuel, base.add(fuel), "USD");
    }
}
