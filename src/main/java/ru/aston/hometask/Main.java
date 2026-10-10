package ru.aston.hometask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("students.json")) {

            if (input == null) {
                throw new IllegalStateException(
                        "Файл students.json не найден"
                );
            }

            List<Student> students = mapper.readValue(
                    input,
                    new TypeReference<List<Student>>() {}
            );

            Optional<Integer> year = students.stream()
                    .filter(student -> student.getBooks() != null
                            && student.getBooks().size() >= 5)
                    .sorted(Comparator.comparingInt(
                            student -> student.getBooks().size()
                    ))
                    .peek(System.out::println)
                    .flatMap(student -> student.getBooks().stream())
                    .sorted(Comparator.comparingInt(Book::getPages))
                    .distinct()
                    .filter(book -> book.getYear() > 2000)
                    .limit(3)
                    .map(Book::getYear)
                    .findFirst();

            System.out.println(
                    year.map(value -> "Год выпуска: " + value).orElse("Подходящий год не найден")
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Ошибка при чтении students.json", e
            );
        }
    }
}
