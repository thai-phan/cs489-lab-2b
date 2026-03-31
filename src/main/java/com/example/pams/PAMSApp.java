package com.example.pams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PAMSApp {
    public static void main(String[] args) throws IOException {
        Patient[] patients = {
                new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
                new Patient(2, "Ana", "Smith", "", "amsith@te.edu", "", LocalDate.of(1948, 12, 5)),
                new Patient(3, "Marcus", "Garvey", "(123) 292-0018", "", "4 East Ave", LocalDate.of(2001, 9, 18)),
                new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", "", LocalDate.of(1995, 2, 28)),
                new Patient(5, "Mary", "Washington", "", "", "30 W Burlington", LocalDate.of(1932, 5, 31))
        };

        String json = buildPatientJson(Arrays.asList(patients), LocalDate.now());
        Path outputPath = Path.of("patients.json");
        Files.writeString(outputPath, json);

        System.out.println("Wrote patient JSON to: " + outputPath.toAbsolutePath());
    }

    static String buildPatientJson(List<Patient> patients, LocalDate asOfDate) {
        List<PatientExport> exportPatients = patients.stream()
                .sorted(Comparator.comparingInt((Patient patient) -> calculateAge(patient.getDateOfBirth(), asOfDate))
                        .reversed()
                        .thenComparingInt(Patient::getPatientId))
                .map(patient -> PatientExport.from(patient, asOfDate))
                .toList();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(exportPatients);
    }

    static int calculateAge(LocalDate dateOfBirth, LocalDate asOfDate) {
        return Period.between(dateOfBirth, asOfDate).getYears();
    }

    private record PatientExport(
            int patientId,
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String mailingAddress,
            String dateOfBirth,
            int age
    ) {
        private static PatientExport from(Patient patient, LocalDate asOfDate) {
            return new PatientExport(
                    patient.getPatientId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getPhoneNumber(),
                    patient.getEmail(),
                    patient.getMailingAddress(),
                    patient.getDateOfBirth().toString(),
                    calculateAge(patient.getDateOfBirth(), asOfDate)
            );
        }
    }
}

