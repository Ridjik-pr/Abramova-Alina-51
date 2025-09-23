package org.example.ru.bmstu;

import org.example.ru.bmstu.domain.Person;
import org.example.ru.bmstu.domain.Student;
import org.example.ru.bmstu.service.PersonDemo;
import org.example.ru.bmstu.service.StudentManager;
import org.example.ru.bmstu.service.StudentPrinter;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Андрей", "Климов", 27, "+79567835124");
            Student student = new Student("Екатерина", "Рублёва", 20, "+79203467534", "ИУК6-31Б", 2);
            Student student2 = new Student("Мария", "Петрова", 18, "+79567832479", "ИУК2-11Б", 1);

            // Добавляем дисциплины студентам
            addDemoSubjects(student);
            addDemoSubjects(student2);

            System.out.println("---- ДЕМОНСТРАЦИЯ ДЛЯ PERSON ----");
            PersonDemo personDemo = new PersonDemo(person);
            personDemo.demo();
            personDemo.demoDismiss();
            personDemo.demoPhoneOperations();

            System.out.println("\n---- ДЕМОНСТРАЦИЯ ДЛЯ STUDENT 1 -----");
            PersonDemo personDemo2 = new PersonDemo(student);
            personDemo2.safePrintInfo();
            personDemo2.demoDismiss();
            personDemo2.demoStudentManagement();

            System.out.println("\n---- ДЕМОНСТРАЦИЯ ДЛЯ STUDENT 2 -----");
            PersonDemo personDemo3 = new PersonDemo(student2);
            personDemo3.demo();
            personDemo3.demoDismiss();
            personDemo3.demoStudentManagement();

        } catch (Person.InvalidPhoneNumberException e) {
            System.out.println("Ошибка при создании объекта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        }
    }

    private static void addDemoSubjects(Student student) {
        student.addSubject("Физика", 4);
        student.addSubject("Математика", 5);
        student.addSubject("Программирование", 5);
        student.addSubject("Английский язык", 3);
        student.addSubject("История", 4);
    }
}