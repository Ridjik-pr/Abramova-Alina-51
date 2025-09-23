package org.example.ru.bmstu.domain;

public class Person {
    private String firstName;
    private String secondName;
    private Integer age;
    private String phone;

    //Исключение
    public static class InvalidPhoneNumberException extends RuntimeException {
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }
    //Конструкторы
    public Person(String firstName, String secondName, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Person(String firstName, String secondName, Integer age, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        setPhone(phone);
    }

    // Геттеры
    public String getfirstName() {
        return firstName;
    }

    public String getsecondName() {
        return secondName;
    }

    public Integer getage() {
        return age;
    }

    public String getphone() {
        return phone;
    }

    //Сеттеры
    public void setPhone(String phone) {
        checkPhone(phone);
        this.phone = phone;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    private void checkPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidPhoneNumberException("Телефонный номер не может быть пустым");
        }

        if (!phone.startsWith("+")) {
            throw new InvalidPhoneNumberException("Телефонный номер должен начинаться с '+'");
        }

        String digitsPart = phone.substring(1);
        if (digitsPart.isEmpty()) {
            throw new InvalidPhoneNumberException("После '+' должны быть цифры");
        }

        if (!digitsPart.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Телефонный номер должен содержать только цифры после '+'");
        }

        if (phone.length() != 12) {
            throw new InvalidPhoneNumberException("Телефонный номер должен содержать 12 символов (формат: +7XXXXXXXXXX)");
        }
    }
}