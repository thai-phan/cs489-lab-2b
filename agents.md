Assume you have been employed as a Software Engineer to
develop a Patients-Appointments booking and management
CLI application for a hospital. The application will be used to
register new Patients who are requesting to receive medical
care, including the Patient’s First Name, Last Name, Contact
Phone Number, Email, Mailing Address and Date of Birth.
For the purpose of this lab assignment, simply create a CLI
application project that uses Maven or Gradle. Add a class
named, Patient, including the necessary data fields
(attributes) as specified above. Make appropriate use of
packages (or namespaces or modules to properly organize
your code). In an executable class named, PAMSApp, in the
main method, add code to simply create an array of Patient
objects (using the data given below).



| Patient Id | First Name | Last Name  | Phone No       | Email                                   | Mailing Address | Date of Birth |
| ---------- | ---------- | ---------- | -------------- | --------------------------------------- | --------------- | ------------- |
| 1          | Daniel     | Agar       | (641) 123-0009 | [dagar@m.as](mailto:dagar@m.as)         | 1 N Street      | 1987-01-19    |
| 2          | Ana        | Smith      | (blank)        | [amsith@te.edu](mailto:amsith@te.edu)   | (blank)         | 1948-12-05    |
| 3          | Marcus     | Garvey     | (123) 292-0018 | (blank)                                 | 4 East Ave      | 2001-09-18    |
| 4          | Jeff       | Goldbloom  | (999) 165-1192 | [jgold@es.co.za](mailto:jgold@es.co.za) | (blank)         | 1995-02-28    |
| 5          | Mary       | Washington | (blank)        | (blank)                                 | 30 W Burlington | 1932-05-31    |


Then add code to convert the Patients data into JSON format
and write the data out to a file in your local filesystem, sorted
by the Patient’s current Age, in descending order (i.e. Oldest
Patient first, Youngest Patient last). Include each Patient’s
age in the JSON data output. 