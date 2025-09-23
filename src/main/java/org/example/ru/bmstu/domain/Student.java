package org.example.ru.bmstu.domain;
import java.util.*;
import java.util.Set;

public class Student extends Person {
        private String group;
        private int course;
        private TreeSet<Subject> subjects;
        //Вложенный класс
        public static class Subject implements Comparable<Subject> {
            private String name;
            private int grade;
            //Конструктор
            public Subject(String name, int grade) {
                this.name = name;
                this.grade = grade;
            }
            //Геттеры
            public String getName() { return name; }
            public int getGrade() { return grade; }

            // Сортировка в обратном алфавитном порядке
            @Override
            public int compareTo(Subject other) {
                return other.name.compareTo(this.name);
            }
            //сравниваются только по названию
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;//проверка типа
                Subject subject = (Subject) o;
                return Objects.equals(name, subject.name);// сравниваем только по названию
            }

            @Override
            public int hashCode() {
                return Objects.hash(name);// хэш вычисляется только по названию
            }
            //красивый вывод
            @Override
            public String toString() {
                return name + ": " + grade;
            }
        }
        //Конструкторы
        public Student(String firstName, String secondName, int age, String group, int course) {
            super(firstName, secondName, age);
            this.group = group;
            this.course = course;
            this.subjects = new TreeSet<>();
        }

        public Student(String firstName, String secondName, int age, String phone, String group, int course) {
            super(firstName, secondName, age, phone);
            this.group = group;
            this.course = course;
            this.subjects = new TreeSet<>();
        }
        //Геттеры
        public String getGroup() { return group; }
        public int getCourse() { return course; }
        public Set<Subject> getSubjects() { return new TreeSet<>(subjects); }//возвращает копию

        //  методы для работы с дисциплинами
        //Добавление нового предмета с оценкой
        public void addSubject(String name, int grade) {
            subjects.add(new Subject(name, grade));
        }
        //Возвращает количество предметов у студента
        public int getSubjectsCount() {
            return subjects.size();
        }

        @Override
        public String toString() {
            return super.toString() +
                    ", group='" + group + '\'' +
                    ", course=" + course +
                    ", subjects=" + subjects;
        }
    }