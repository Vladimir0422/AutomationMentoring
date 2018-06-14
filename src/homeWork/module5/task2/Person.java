package homeWork.module5.task2;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/8/2018
 */


public class Person {
    private String name;
    private String surname;
    private String email;

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

    Person() {

    }

    Person(String getName, String getSurname, String getEmail) {
        name = getName;
        surname = getSurname;
        email = getEmail;
    }

    public void printInfo() {
        System.out.println(getName() + " " + getSurname() + " " + getEmail());
    }
}
