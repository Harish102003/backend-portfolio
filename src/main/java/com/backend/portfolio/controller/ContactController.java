package com.backend.portfolio.controller;
import com.backend.portfolio.dto.ContactRequest;
import com.backend.portfolio.entity.ContactMessage;
import com.backend.portfolio.service.ContactService;
import jakarta.validation.Valid; // <-- Added
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<?> submitContact(@Valid @RequestBody ContactRequest request) {
        ContactMessage saved = contactService.save(request);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Your message has been received.",
                "id", saved.getId()));
    }
}
