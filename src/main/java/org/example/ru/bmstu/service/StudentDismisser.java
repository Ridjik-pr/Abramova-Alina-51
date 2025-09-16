package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Person;
import org.example.ru.bmstu.domain.Student;

public class StudentDismisser implements Dismissable {
    @Override
    public void dismiss(Person p){
        if(p instanceof Student){
            Student student  = (Student) p;
            System.out.println("\nStudent dismiss:");
            System.out.println("--- Полная информация о студенте ---");
            System.out.println("Имя: " + student.getfirstName());
            System.out.println("Фамилия: " + student.getsecondName());
            System.out.println("Возраст: " + student.getage() + " лет");
            System.out.println("Группа: " + student.getGroup());
            System.out.println("Курс: " + student.getCourse());
            System.out.println("Номер телефона: " + student.getphone());
        }
    }

}
