package org.example.ru.bmstu.service;
import org.example.ru.bmstu.domain.Person;
import org.example.ru.bmstu.domain.Student;

    public class PersonDemo {
        private Person person;

        public PersonDemo(Person person) {
            this.person = person;
        }
        //главная демонстрация
        public void demo() {
            System.out.println("\n--- Демонстрация PersonPrinter ---");
            PersonPrinter.printFI(person);

            System.out.println("\nПолная информация о человеке:");
            PersonPrinter.printInfo(person);

            demoPhoneOperations();
        }

        public void demoDismiss() {
            System.out.println("\n--- Демонстрация Dismissable ---");
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println("Student dismiss:");
                new StudentDismisser().dismiss(person);
            } else {
                System.out.println("Default dismiss:");
                new Dismissable() {}.dismiss(person);
            }
        }
        //управление студентом
        public void demoStudentManagement() {
            if (!(person instanceof Student)) {
                System.out.println("Демонстрация доступна только для студентов");
                return;
            }
            Student student = (Student) person;
            new StudentManager().demoStudentManagement(student);
        }
        // работа с телефонными номерами
        public void demoPhoneOperations() {
            System.out.println("\n--- Демонстрация работы с телефоном ---");

            // Текущий номер
            try {
                String phone = person.getphone();
                System.out.println(phone != null ? "Текущий телефон: " + phone : "Телефон не установлен");
            } catch (Exception e) {
                System.out.println("Ошибка получения телефона: " + e.getMessage());
            }

            // Тестовые сценарии
            String[] testPhones = {
                    "+79123456789",    // валидный
                    "89123456789",     // без +
                    "+79123",          // короткий
                    "+791234567890123", // длинный
                    "+79123abc789",    // с буквами
                    null,              // null
                    ""                 // пустой
            };

            String originalPhone = person.getphone();

            for (String phone : testPhones) {
                safeSetPhone(phone);
            }

            // Восстановление оригинального номера
            if (originalPhone != null) {
                safeSetPhone(originalPhone);
            }
        }
        // безопасная установка телефона
        public boolean safeSetPhone(String phoneNumber) {
            try {
                person.setPhone(phoneNumber);
                System.out.println("Успешно установлен: " + phoneNumber);
                return true;
            } catch (Person.InvalidPhoneNumberException e) {
                System.out.println("Ошибка '" + phoneNumber + "': " + e.getMessage());
                return false;
            }
        }
        //безопасный вывод информации
        public void safePrintInfo() {
            try {
                System.out.println("\n--- Информация о человеке ---");
                System.out.println("Имя: " + person.getfirstName());
                System.out.println("Фамилия: " + person.getsecondName());
                System.out.println("Возраст: " + person.getage());

                String phone = person.getphone();
                System.out.println("Телефон: " + (phone != null ? phone : "не установлен"));

                if (person instanceof Student) {
                    Student student = (Student) person;  // Явное приведение
                    System.out.println("Группа: " + student.getGroup());
                    System.out.println("Курс: " + student.getCourse());
                }
            } catch (Exception e) {
                System.out.println("Ошибка получения информации: " + e.getMessage());
            }
        }
    }