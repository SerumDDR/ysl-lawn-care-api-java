package com.serumddr.ysl_lawn_care_api; // NOTE: The package name must match your folder structure

// A class to hold the data sent from the contact form
public class ContactForm {

    // These names MUST match the 'name' attributes in your HTML form fields (camelCase convention)
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String questions;
    private String website; // Honeypot field
    private String reference;

    private String[] method;
    private String[] time;
    private String[] interest;

    // --- Getters and Setters (Required for Spring) ---

    // Getter for fName
    public String getFName() {
        return fName;
    }

    // Setter for fName
    public void setFName(String fName) {
        this.fName = fName;
    }

    // Getter for lName
    public String getLName() {
        return lName;
    }

    // Setter for lName
    public void setLName(String lName) {
        this.lName = lName;
    }
    
    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for questions
    public String getQuestions() {
        return questions;
    }

    // Setter for questions
    public void setQuestions(String questions) { // Corrected: removed 'void' return type in setter
        this.questions = questions;
    }

    // Getter for honeypot field
    public String getWebsite() {
        return website;
    }

    // Setter for honeypot field
    public void setWebsite(String website) {
        this.website = website;
    }

    // Getter for reference
    public String getReference() {
        return reference;
    }

    // Setter for reference
    public void setReference(String reference) {
        this.reference = reference;
    }

    // --- Getters and Setters for Checkbox Arrays ---
    public String[] getMethod() {
        return method;
    }

    public void setMethod(String[] method) {
        this.method = method;
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public String[] getInterest() {
        return interest;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }
}