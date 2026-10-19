package com.example.parcel.labels;
import jakarta.validation.constraints.*;
public record LabelRequest(@NotBlank String quoteId, @NotBlank String senderName, @NotBlank String recipientName,
                           @NotBlank String destinationPostalCode, @Positive double weightKg) {}
