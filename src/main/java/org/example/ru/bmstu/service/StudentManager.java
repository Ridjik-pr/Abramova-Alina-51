package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // добавление студента
    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
            System.out.println("Студент " + student.getfirstName() + " " +
                    student.getsecondName() + " добавлен");
        }
    }

    //поиск по имени/фамилии
    public Student findByName(String name) {
        for (Student student : students) {
            if (student.getfirstName().equalsIgnoreCase(name) ||
                    student.getsecondName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    //поиск по количеству дисциплин
    public List<Student> findBySubjectCount(int minSubjects) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getSubjectsCount() >= minSubjects) {
                result.add(student);
            }
        }
        return result;
    }

    // поиск по среднему баллу
    public List<Student> findByAverageGrade(double minAverage) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getSubjectsCount() > 0) {
                double average = calculateAverageGrade(student);
                if (average > minAverage) {
                    result.add(student);
                }
            }
        }
        return result;
    }

    // вычисление среднего балла
    private double calculateAverageGrade(Student student) {
        if (student.getSubjectsCount() == 0) {
            return 0.0;
        }

        int sum = 0;
        int count = 0;
        for (Student.Subject subject : student.getSubjects()) {
            sum += subject.getGrade();
            count++;
        }
        return (double) sum / count;
    }

    //удаление студента
    public void removeStudent(String name) {
        Student studentToRemove = findByName(name);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Студент " + name + " удален");
        } else {
            System.out.println("Студент " + name + " не найден");
        }
    }

    // ДЕМОНСТРАЦИЯ
    public void demoStudentManagement(Student currentStudent) {
        System.out.println("\n---- ДЕМОНСТРАЦИЯ STUDENT MANAGER -----");

        // Добавляем студентов
        Student testStudent1 = new Student("Иван", "Сидоров", 20, "МК3-21Б", 2);
        testStudent1.addSubject("Математика", 5);
        testStudent1.addSubject("Физика", 4);

        Student testStudent2 = new Student("Анна", "Иванова", 22, "ИУК7-72", 1);
        testStudent2.addSubject("Программирование", 5);

        this.addStudent(testStudent1);
        this.addStudent(testStudent2);
        this.addStudent(currentStudent);

        // Демонстрация функциональности
        System.out.println("\n1. Все студенты в системе:");
        this.printAllStudents();

        System.out.println("\n2. Поиск студента '" + currentStudent.getfirstName() + "':");
        Student foundStudent = this.findByName(currentStudent.getfirstName());
        if (foundStudent != null) {
            // StudentPrinter.printStudentInfo(foundStudent); // раскомментируйте если есть этот класс
            System.out.println("Найден: " + foundStudent);
        }

        System.out.println("\n3. Студенты с 2 и более дисциплинами:");
        List<Student> studentsWithSubjects = this.findBySubjectCount(2);
        for (Student s : studentsWithSubjects) {
            // StudentPrinter.printBriefInfo(s); // раскомментируйте если есть этот класс
            System.out.println(s.getfirstName() + " " + s.getsecondName() + " - предметов: " + s.getSubjectsCount());
        }

        // Демонстрация нового метода
        System.out.println("\n4. Студенты со средним баллом выше 4.5:");
        List<Student> studentsWithHighAverage = this.findByAverageGrade(4.5);
        for (Student s : studentsWithHighAverage) {
            double average = calculateAverageGrade(s);
            System.out.println(s.getfirstName() + " " + s.getsecondName() + " - средний балл: " + average);
        }

        System.out.println("\n5. Демонстрация удаления студента:");
        this.removeStudent("Иван");

        System.out.println("\n6. Список после удаления:");
        this.printAllStudents();
    }

    // защитное копирование
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public int getStudentCount() {
        return students.size();
    }

    //красивый вывод
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст");
            return;
        }
        System.out.println("----СПИСОК ВСЕХ СТУДЕНТОВ ----");
        for (int i = 0; i < students.size(); i++) {
            System.out.print((i + 1) + ". ");
            Student student = students.get(i);
            System.out.println(student.getfirstName() + " " + student.getsecondName() +
                    " - группа: " + student.getGroup() + ", курс: " + student.getCourse());
        }
    }
}