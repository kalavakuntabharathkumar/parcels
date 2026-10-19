package com.example.parcel.labels;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/labels")
public class LabelController {
    @PostMapping
    public LabelResponse create(@Valid @RequestBody LabelRequest request) {
        String id = UUID.randomUUID().toString();
        return new LabelResponse(id, "TRK-" + id.substring(0, 8).toUpperCase(), "CREATED",
                "/api/v1/labels/" + id + "/document");
    }
    @GetMapping("/health") public String health() { return "label-service:UP"; }
}
