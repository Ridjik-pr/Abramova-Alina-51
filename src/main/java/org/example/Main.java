package org.example;
import org.example.ru.bmstu.domain.Person;
import org.example.ru.bmstu.domain.Student;
import org.example.ru.bmstu.service.PersonDemo;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Андрей","Климов" , 27, "+79546783124");
        Student student = new Student("Екатерина", "Рублёва", 20, "+79203467534", "ИУК6-31Б", 2);

        Person student2 = new Student("Мария", "Петрова", 18, "+79567832479", "ИУК2-11Б", 1);

        System.out.println("---- ДЕМОНСТРАЦИЯ ДЛЯ PERSON ----");
        PersonDemo personDemo = new PersonDemo(person);
        personDemo.demo();
        personDemo.demoDismiss();

        System.out.println("\n---- ДЕМОНСТРАЦИЯ ДЛЯ STUDENT -----");
        PersonDemo personDemo2 = new PersonDemo(student);
        personDemo2.demoDismiss();

        PersonDemo personDemo3 = new PersonDemo(student2);
        personDemo3.demoDismiss();
    }
}

