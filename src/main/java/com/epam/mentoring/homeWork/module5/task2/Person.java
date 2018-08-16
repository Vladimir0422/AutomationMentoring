package com.epam.mentoring.homeWork.module5.task2;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/8/2018
 */


public class Person {
    private String name;
    private String surname;
    private String email;

    Person() {

    }

    Person(String getName, String getSurname, String getEmail) {
        name = getName;
        surname = getSurname;
        email = getEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!surname.equals(person.surname)) return false;
        return email.equals(person.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printInfo() {
        System.out.println(getName() + " " + getSurname() + " " + getEmail());
    }
}
