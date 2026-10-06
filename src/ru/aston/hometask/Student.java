package ru.aston.hometask;

public class Student {
    private int personalID;

    public Student(int personalID){
        this.personalID = personalID;
    }

    //конструктор копирования
    public Student(Student student){
        this.personalID = student.personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }

    public int getPersonalID(){
        return personalID;
    }

    @Override
    public String toString(){
        return "персональный номер - " + personalID;
    }
}
