package ru.aston.hometask.decorator;

import ru.aston.hometask.Student;

public class BasicStudentInfo implements StudentInfo {

    private final Student student;

    public BasicStudentInfo(Student student) {
        this.student = student;
    }

    @Override
    public String getInfo() {
        return "Студент: " + student.getName()
                + ", факультет: " + student.getFaculty()
                + ", год поступления: " + student.getAdmissionYear();
    }
}