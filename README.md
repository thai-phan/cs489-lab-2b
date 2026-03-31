# CS489 Lab 2B

A simple Java 25 Gradle CLI app that creates patient records, sorts them by current age in descending order, and writes the result to `patients.json` in the project root.

## Run

```bash
gradle run
```

## Output

The app writes a JSON array to `patients.json` with each patient including:
- id
- firstName
- lastName
- phoneNumber
- email
- mailingAddress
- dateOfBirth
- age

