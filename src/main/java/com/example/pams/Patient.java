package com.example.pams;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Patient {
    private final int patientId;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final String mailingAddress;
    private final LocalDate dateOfBirth;

    public Patient(int patientId,
                   String firstName,
                   String lastName,
                   String phoneNumber,
                   String email,
                   String mailingAddress,
                   LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.firstName = Objects.requireNonNullElse(firstName, "");
        this.lastName = Objects.requireNonNullElse(lastName, "");
        this.phoneNumber = Objects.requireNonNullElse(phoneNumber, "");
        this.email = Objects.requireNonNullElse(email, "");
        this.mailingAddress = Objects.requireNonNullElse(mailingAddress, "");
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth, "dateOfBirth");
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}

