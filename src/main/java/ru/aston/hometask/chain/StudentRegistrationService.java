package ru.aston.hometask.chain;

import ru.aston.hometask.Student;
import ru.aston.hometask.strategy.StudentSortStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRegistrationService {

    private final List<Student> students = new ArrayList<>();
    private final Set<Integer> existingIds = new HashSet<>();
    private final StudentValidator validator;

    public StudentRegistrationService() {
        StudentValidator nameValidator = new NameValidator();
        StudentValidator idValidator = new IdValidator(existingIds);
        StudentValidator ageValidator = new AgeValidator();
        StudentValidator booksValidator = new BooksValidator();

        nameValidator
                .setNext(idValidator)
                .setNext(ageValidator)
                .setNext(booksValidator);

        this.validator = nameValidator;
    }

    public boolean register(Student student) {
        if (!validator.validate(student)) {
            return false;
        }

        students.add(student);
        existingIds.add(student.getId());

        System.out.println("Студент успешно зарегистрирован.");
        return true;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> sortStudents(StudentSortStrategy strategy) {
        return strategy.sort(getStudents());
    }
}