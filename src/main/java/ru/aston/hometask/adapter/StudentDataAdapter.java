package ru.aston.hometask.adapter;

import ru.aston.hometask.Student;

public interface StudentDataAdapter {
    Student adapt(LegacyStudentRecord record);
}