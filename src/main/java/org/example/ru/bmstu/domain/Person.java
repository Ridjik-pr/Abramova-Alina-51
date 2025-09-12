package org.example.ru.bmstu.domain;

public class Person {
    private String firstName;
    private String secondName;
    private Integer age;
    private String phone;
    Person(String firstName,String secondName, Integer age)    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
    Person(String firstName,String secondName, Integer age, String phone)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.phone = phone;
    }
    //Геттеры
    public String getfirstName() {
        return firstName;
    }
    public String getsecondName() {
        return secondName;
    }
    public Integer getage () {
        return age;
    }
    public String getphone() {
        return phone;
    }

    // Сеттер
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAge(Integer age) {
        this. age = age;
    }
}
