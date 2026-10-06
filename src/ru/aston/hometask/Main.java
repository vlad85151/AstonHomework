package ru.aston.hometask;

class Main {
    public static void main(String[] args)   {
        Student student = new Student(234123);

        Human human = new Human("Vladislav", 22, student);

        System.out.println("До изменения Student:");
        System.out.println(human);

        student.setPersonalID(1515115);

        System.out.println("После изменения Student:");
        System.out.println(human);
    }
}