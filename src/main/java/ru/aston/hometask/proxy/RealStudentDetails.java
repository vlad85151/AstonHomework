package ru.aston.hometask.proxy;

import ru.aston.hometask.Student;

public class RealStudentDetails implements StudentDetails {

    private final Student student;

    public RealStudentDetails(Student student) {
        this.student = student;
    }

    @Override
    public void showDetails() {
        System.out.println("Полная информация о студенте:");
        System.out.println("ID: " + student.getId());
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Факультет: " + student.getFaculty());
        System.out.println("Год поступления: " + student.getAdmissionYear());
        System.out.println("Книги: " + student.getBooks());
    }
}