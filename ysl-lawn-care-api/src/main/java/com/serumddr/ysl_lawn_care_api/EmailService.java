package com.serumddr.ysl_lawn_care_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// Annotating this class as a Service tells Spring to manage it.
@Service 
public class EmailService {

    // Spring automatically provides an instance of this mail sender (like getting Nodemailer ready)
    @Autowired 
    private JavaMailSender mailSender; 

    // Injecting values from application.properties or Render Environment Variables
    // The @Value annotation pulls the secret recipient email from the configuration.
    @Value("${notify.email}")
    private String recipientEmail; 

    @Value("${spring.mail.username}")
    private String senderEmail;

    // We will call this method from our Controller when a form is submitted
    public void sendContactEmail(ContactForm form) {
        
        // This object represents the email we are going to send
        SimpleMailMessage message = new SimpleMailMessage(); 
        
        // --- Set Email Details ---
        
        // This is who the email appears to be FROM
        message.setFrom(senderEmail);
        
        // This is the email address that will RECEIVE the form submission
        message.setTo(recipientEmail);
        
        // Set the subject line
        message.setSubject("New YSL Lawn Care Contact Form Submission");

        // Format the body of the email using the form data
        String emailBody = String.format(
            "Contact Details:\n" +
            "First Name: %s\n" +
            "Last Name: %s\n" +
            "Email: %s\n" +
            "Phone: %s\n" +
            "Questions: %s",
            form.getFName(),
            form.getLName(),
            form.getEmail(),
            form.getPhone(),
            form.getQuestions()
        );
        
        message.setText(emailBody);

        // --- Send Email ---
        // The core Java Mail logic: attempts to send the message.
        mailSender.send(message); 
    }
}