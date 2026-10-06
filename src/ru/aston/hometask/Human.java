package ru.aston.hometask;

import java.util.Objects;

public final class Human {
    private final String name;
    private final int age;
    private final Student student;

    public Human(String name, int age, Student student){
        this.name = name;
        this.age = age;
        this.student = new Student(Objects.requireNonNull(student, "Студент не определён"));
    }

    public Student getStudent(){
        return new Student(student);
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Имя - " + name + ", возраст - " + age + ", " + student;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Human human1 = (Human) obj;
        return student.getPersonalID() == human1.student.getPersonalID();
    }

    @Override
    public int hashCode(){
        return Objects.hash(student.getPersonalID());
    }

}
