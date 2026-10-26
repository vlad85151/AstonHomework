package ru.aston.hometask.proxy;

import ru.aston.hometask.Student;

public class StudentDetailsProxy implements StudentDetails {

    private final Student student;
    private final StudentDetails realDetails;
    private final boolean isAdmin;

    public StudentDetailsProxy(Student student, boolean isAdmin) {
        this.student = student;
        this.realDetails = new RealStudentDetails(student);
        this.isAdmin = isAdmin;
    }

    @Override
    public void showDetails() {
        if (isAdmin) {
            realDetails.showDetails();
        } else {
            System.out.println("Общая информация о студенте:");
            System.out.println("Имя: " + student.getName());
            System.out.println("Факультет: " + student.getFaculty());
            System.out.println(
                    "Год поступления: " + student.getAdmissionYear()
            );
            System.out.println("Доступ к подробной информации запрещён.");
        }
    }
}