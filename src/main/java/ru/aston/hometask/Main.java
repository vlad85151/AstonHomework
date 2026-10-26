package ru.aston.hometask;

import ru.aston.hometask.builder.StudentBuilder;
import ru.aston.hometask.chain.StudentRegistrationService;
import ru.aston.hometask.strategy.SortByBookCount;
import ru.aston.hometask.strategy.SortByName;
import ru.aston.hometask.proxy.StudentDetails;
import ru.aston.hometask.proxy.StudentDetailsProxy;
import ru.aston.hometask.decorator.StudentInfo;
import ru.aston.hometask.decorator.BasicStudentInfo;
import ru.aston.hometask.decorator.StudentInfoDecorator;
import ru.aston.hometask.adapter.LegacyStudentRecord;
import ru.aston.hometask.adapter.StudentDataAdapter;
import ru.aston.hometask.adapter.LegacyStudentAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Chain:
        StudentRegistrationService service =
                new StudentRegistrationService();

        // Builder:
        service.register(createStudent(
                101, "Алексей", 20, 2024, 5
        ));

        service.register(createStudent(
                102, "Мария", 21, 2023, 7
        ));

        service.register(createStudent(
                103, "Дмитрий", 19, 2025, 6
        ));

        // Strategy
        System.out.println("\n=== Сортировка по имени ===");
        service.sortStudents(new SortByName())
                .forEach(System.out::println);

        System.out.println("\n=== Сортировка по количеству книг ===");
        service.sortStudents(new SortByBookCount())
                .forEach(System.out::println);

        // Proxy:
        Student student = service.getStudents().get(0);

        System.out.println("\n=== Обычный пользователь ===");
        StudentDetails userDetails =
                new StudentDetailsProxy(student, false);
        userDetails.showDetails();

        System.out.println("\n=== Администратор ===");
        StudentDetails adminDetails =
                new StudentDetailsProxy(student, true);
        adminDetails.showDetails();

        // Decorator
        Student studentForDecorator = service.getStudents().get(0);

        System.out.println("\n=== Обычная информация ===");
        StudentInfo basicInfo =
                new BasicStudentInfo(studentForDecorator);
        System.out.println(basicInfo.getInfo());

        System.out.println("\n=== Расширенная информация ===");
        StudentInfo extendedInfo =
                new StudentInfoDecorator(
                        basicInfo,
                        studentForDecorator
                );
        System.out.println(extendedInfo.getInfo());

        // Adapter
        System.out.println("\n=== Adapter ===");
        LegacyStudentRecord oldRecord = new LegacyStudentRecord(
                104,
                "Иван Петров",
                22,
                "Экономический",
                2022
        );

        // Преобразование
        StudentDataAdapter adapter = new LegacyStudentAdapter();
        Student adaptedStudent = adapter.adapt(oldRecord);
        System.out.println("Студент, полученный через Adapter:");
        System.out.println(adaptedStudent);
    }


    // Builder:
    private static Student createStudent(
            int id,
            String name,
            int age,
            int admissionYear,
            int bookCount
    ) {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= bookCount; i++) {
            books.add(new Book(
                    "Книга " + i,
                    "Автор " + i,
                    100 + i * 20,
                    2020 + i
            ));
        }

        return new StudentBuilder()
                .id(id)
                .name(name)
                .age(age)
                .faculty("IT")
                .admissionYear(admissionYear)
                .books(books)
                .build();
    }
}