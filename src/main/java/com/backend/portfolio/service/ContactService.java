package com.backend.portfolio.service;

import com.backend.portfolio.dto.ContactRequest;
import com.backend.portfolio.entity.ContactMessage;
import com.backend.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactMessageRepository repo;

    public ContactService(ContactMessageRepository repo) {
        this.repo = repo;
    }

    public ContactMessage save(ContactRequest req) {
        ContactMessage msg = new ContactMessage();
        msg.setName(req.getName());
        msg.setEmail(req.getEmail());
        msg.setSubject(req.getSubject());
        msg.setMessage(req.getMessage());
        return repo.save(msg);
    }
}
