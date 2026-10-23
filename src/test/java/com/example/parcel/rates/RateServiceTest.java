package com.example.parcel.rates;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
class RateServiceTest {
    private final RateService service = new RateService();
    @Test void calculatesStandardQuote() {
        RateQuote quote = service.quote(new RateRequest("10001", "94105", 2.0, "STANDARD"));
        assertEquals(new BigDecimal("7.20"), quote.baseAmount());
        assertEquals(new BigDecimal("0.86"), quote.fuelSurcharge());
        assertEquals(new BigDecimal("8.06"), quote.totalAmount());
    }
    @Test void expressCostsMoreThanStandard() {
        var standard = service.quote(new RateRequest("10001", "94105", 2.0, "STANDARD"));
        var express = service.quote(new RateRequest("10001", "94105", 2.0, "EXPRESS"));
        assertTrue(express.totalAmount().compareTo(standard.totalAmount()) > 0);
    }
    @Test void returnsCurrencyAndQuoteId() {
        var quote = service.quote(new RateRequest("10001", "94105", 1.0, "ECONOMY"));
        assertEquals("USD", quote.currency());
        assertFalse(quote.quoteId().isBlank());
    }
}
