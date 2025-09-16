package org.example.ru.bmstu.domain;

public class Student extends Person{
    private String group;
    private int course;

    public Student(String firstName, String secondName, int age, String group, int course ){
        super(firstName, secondName, age);
        this.group = group;
        this.course = course;
    }

    public Student(String firstName, String secondName, int age, String phone, String group, int course) {
        super(firstName, secondName, age, phone);
        this.group = group;
        this.course = course;
    }

    public String getGroup(){return group;}
    public int getCourse(){return course;}

    public void setGroup(String group){
        this.group = group;
    }

    public void setCourse(int course){
        if(course > 0 && course <= 6){
            this.course = course;
        }
        else{
            System.out.println("Ошибка ввода курса! Курс должен быть отличный от 0 и не более 6");
        }
    }
}
