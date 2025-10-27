package com.serumddr.ysl_lawn_care_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/api") 
// **CORS FIX:** Allows your Netlify site to talk to this API
@CrossOrigin(origins = {"https://ysl-lawn-care.netlify.app", "http://localhost:3000"}) 
public class ContactController {

    @Autowired 
    private EmailService emailService;

    @PostMapping("/contact-form") // Your API Endpoint: /api/contact-form
    public ResponseEntity<String> submitForm(@RequestBody ContactForm form) {

        // --- Honeypot Check (Skipped for brevity, but include here) ---
        if (form.getWebsite() != null && !form.getWebsite().trim().isEmpty()) {
            return new ResponseEntity<>("Spam submission blocked.", HttpStatus.OK);
        }

        // --- Validation Check ---
        if (form.getFName() == null || form.getFName().trim().isEmpty() ||
            form.getEmail() == null || form.getEmail().trim().isEmpty()) 
        {
            return new ResponseEntity<>("Please fill in all required fields.", HttpStatus.BAD_REQUEST);
        }

        // --- Email Sending Logic ---
        try {
            emailService.sendContactEmail(form);
            
            // Success response (HTTP 200 OK)
            return new ResponseEntity<>("Thank you for your submission! We will get back to you soon.", HttpStatus.OK);
            
        } catch (Exception e) {
            System.err.println("Email sending failed: " + e.getMessage());
            
            // Error response (HTTP 500 Internal Server Error)
            return new ResponseEntity<>("There was an error sending your message. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}