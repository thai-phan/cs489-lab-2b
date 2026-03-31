package com.example.pams;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PAMSAppTest {
    @Test
    void buildPatientJson_sortsByAgeDescending_andIncludesAge() {
        List<Patient> patients = List.of(
                new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
                new Patient(2, "Ana", "Smith", "", "amsith@te.edu", "", LocalDate.of(1948, 12, 5)),
                new Patient(3, "Marcus", "Garvey", "(123) 292-0018", "", "4 East Ave", LocalDate.of(2001, 9, 18)),
                new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", "", LocalDate.of(1995, 2, 28)),
                new Patient(5, "Mary", "Washington", "", "", "30 W Burlington", LocalDate.of(1932, 5, 31))
        );

        String json = PAMSApp.buildPatientJson(patients, LocalDate.of(2026, 3, 31));
        JsonArray array = JsonParser.parseString(json).getAsJsonArray();

        assertEquals(5, array.size());

        int[] expectedIds = {5, 2, 1, 4, 3};
        String[] expectedFirstNames = {"Mary", "Ana", "Daniel", "Jeff", "Marcus"};
        String[] expectedLastNames = {"Washington", "Smith", "Agar", "Goldbloom", "Garvey"};
        String[] expectedPhoneNumbers = {"", "", "(641) 123-0009", "(999) 165-1192", "(123) 292-0018"};
        String[] expectedEmails = {"", "amsith@te.edu", "dagar@m.as", "jgold@es.co.za", ""};
        String[] expectedMailingAddresses = {"30 W Burlington", "", "1 N Street", "", "4 East Ave"};
        String[] expectedDatesOfBirth = {"1932-05-31", "1948-12-05", "1987-01-19", "1995-02-28", "2001-09-18"};
        int[] expectedAges = {93, 77, 39, 31, 24};

        for (int i = 0; i < array.size(); i++) {
            JsonObject patient = array.get(i).getAsJsonObject();
            assertEquals(expectedIds[i], patient.get("patientId").getAsInt());
            assertEquals(expectedFirstNames[i], patient.get("firstName").getAsString());
            assertEquals(expectedLastNames[i], patient.get("lastName").getAsString());
            assertEquals(expectedPhoneNumbers[i], patient.get("phoneNumber").getAsString());
            assertEquals(expectedEmails[i], patient.get("email").getAsString());
            assertEquals(expectedMailingAddresses[i], patient.get("mailingAddress").getAsString());
            assertEquals(expectedDatesOfBirth[i], patient.get("dateOfBirth").getAsString());
            assertEquals(expectedAges[i], patient.get("age").getAsInt());
        }
    }
}

