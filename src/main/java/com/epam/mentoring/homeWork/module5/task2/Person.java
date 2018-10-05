package com.epam.mentoring.homeWork.module5.task2;

import java.util.Objects;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/8/2018
 */


public class Person {
    private String name;
    private String surname;
    private String email;
    private Pet pet;
    private Hobby hobby;
    private int numberOfChildren;
    private Gender gender;

    public Person() {
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Pet getPet() {
        return pet;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public Gender getGender() {
        return gender;
    }

    public static Builder newBuilder() {
        return new Person().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setName(String name) {
            Person.this.name = name;

            return this;
        }

        public Builder setSurname(String surname) {
            Person.this.surname = surname;

            return this;
        }

        public Builder setEmail(String email) {
            Person.this.email = email;

            return this;
        }

        public Builder setPet(Pet pet) {
            Person.this.pet = pet;

            return this;
        }

        public Builder setHobby(Hobby hobby) {
            Person.this.hobby = hobby;

            return this;
        }

        public Builder setNumberOfChildren(int numberOfChildren) {
            Person.this.numberOfChildren = numberOfChildren;

            return this;
        }

        public Builder setGender(Gender gender) {
            Person.this.gender = gender;

            return this;
        }

        public Person build() {
            return Person.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getNumberOfChildren() == person.getNumberOfChildren() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSurname(), person.getSurname()) &&
                Objects.equals(getEmail(), person.getEmail()) &&
                Objects.equals(getPet(), person.getPet()) &&
                Objects.equals(getHobby(), person.getHobby()) &&
                Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getEmail(), getPet(), getHobby(), getNumberOfChildren(), getGender());
    }

    @Override
    public String toString() {
        return "Entity.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + email + '\'' +
                ", pet='" + pet + '\'' +
                ", hobby='" + hobby + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void printInfo() {
        System.out.println(getName() + " " + getSurname() + " " + getEmail());
    }
}
