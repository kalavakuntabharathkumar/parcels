package com.example.parcel.rates;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/rates")
public class RateController {
    private final RateService service;
    public RateController(RateService service) { this.service = service; }
    @PostMapping("/quote")
    public RateQuote quote(@Valid @RequestBody RateRequest request) { return service.quote(request); }
    @GetMapping("/health")
    public String health() { return "parcel-rate-service:UP"; }
}
