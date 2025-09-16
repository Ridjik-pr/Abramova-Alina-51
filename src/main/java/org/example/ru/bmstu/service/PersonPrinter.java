package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Person;

public final class PersonPrinter {
    public static void printFI(Person p){
        System.out.println("Имя и фамилия: " + p.getfirstName() + " " + p.getsecondName());
    }

    public static void printInfo(Person p){
        System.out.printf("Имя: %s ", p.getfirstName());
        System.out.printf(", Фамилия: %s ", p.getsecondName());
        System.out.printf(", Возраст: %d ", p.getage());
        System.out.printf(", Номер телефона: %s ", p.getphone() + ".");
    }
}
