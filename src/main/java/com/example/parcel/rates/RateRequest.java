package com.example.parcel.rates;
import jakarta.validation.constraints.*;
public record RateRequest(@NotBlank String originPostalCode, @NotBlank String destinationPostalCode,
                          @Positive double weightKg, @NotBlank String serviceLevel) {}
