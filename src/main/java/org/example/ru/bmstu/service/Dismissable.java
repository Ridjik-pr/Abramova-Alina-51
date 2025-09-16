package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Person;

public interface Dismissable {
    default void dismiss(Person p){
        System.out.println("Имя и фамилия человека: " + p.getfirstName() + " " + p.getsecondName());
    }

}