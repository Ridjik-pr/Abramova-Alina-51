package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Student;

public class StudentPrinter {

    public static void printStudentInfo(Student student) {
        if (student == null) {
            System.out.println("Студент не найден");
            return;
        }

        System.out.println("---- ИНФОРМАЦИЯ О СТУДЕНТЕ ----");
        System.out.println("Имя: " + student.getfirstName());
        System.out.println("Фамилия: " + student.getsecondName());
        System.out.println("Возраст: " + student.getage() + " лет");
        System.out.println("Группа: " + student.getGroup());
        System.out.println("Курс: " + student.getCourse());
        System.out.println("Телефон: " + (student.getphone() != null ? student.getphone() : "не указан"));

        printStudentSubjects(student);
    }
    //вывод дисциплин
    public static void printStudentSubjects(Student student) {
        if (student.getSubjectsCount() > 0) {
            System.out.println("Дисциплины (" + student.getSubjectsCount() + "):");
            int index = 1;
            for (Student.Subject subject : student.getSubjects()) {
                System.out.println("  " + index + ". " + subject);
                index++;
            }
        } else {
            System.out.println("Дисциплины: не добавлены");
        }
    }
    //краткая информация
    public static void printBriefInfo(Student student) {
        if (student == null) return;
        System.out.println(student.getfirstName() + " " + student.getsecondName() +
                " - Группа: " + student.getGroup() +
                ", Курс: " + student.getCourse() +
                ", Дисциплин: " + student.getSubjectsCount());
    }
}
