package ru.aston.hometask.adapter;

public class LegacyStudentRecord {

    private final int studentNumber;
    private final String fullName;
    private final int studentAge;
    private final String department;
    private final int yearOfAdmission;

    public LegacyStudentRecord(
            int studentNumber,
            String fullName,
            int studentAge,
            String department,
            int yearOfAdmission
    ) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.studentAge = studentAge;
        this.department = department;
        this.yearOfAdmission = yearOfAdmission;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }
}