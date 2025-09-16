package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Person;
public class PersonDemo {
        private Person person;

        public PersonDemo(Person person){
            this.person = person;
        }

        public void demo(){
            System.out.println("\n--- Демонстрация PersonPrinter ---");
            PersonPrinter.printFI(person);

            System.out.println("\nПолная информация о человеке:");
            PersonPrinter.printInfo(person);
        }

        public void demoDismiss(){
            System.out.println("\n--- Демонстрация Dismissable ---");

            Dismissable defDismissable = new Dismissable() {};
            StudentDismisser sDismisser = new StudentDismisser();

            System.out.println("Default dismiss:");
            defDismissable.dismiss(person);
            sDismisser.dismiss(person);
        }
}
