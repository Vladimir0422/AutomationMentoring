package com.epam.mentoring.homeWork.module5.task2;

import java.util.HashMap;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/8/2018
 */


public class DisplayInfoFromPerson {
    public static void main(String[] args) {
        HashMap<Passport, Person> personInfo = new HashMap<Passport, Person>();

        Person firstPerson = new Person("Vova", "Sil", "email@com");
        Person secondPerson = new Person();

        secondPerson.setName("Vova");
        secondPerson.setSurname("Sil");
        secondPerson.setEmail("email@com");

        Passport passportInfo = new Passport();
        Passport passportInfo2 = new Passport();
        passportInfo.setSeries("NA");
        passportInfo.setNumber(1234);
        passportInfo2.setSeries("NT");
        passportInfo2.setNumber(987);

        firstPerson.printInfo();
        secondPerson.printInfo();
        passportInfo.printPassportInfo();
        personInfo.put(passportInfo, firstPerson);
        personInfo.put(passportInfo2, secondPerson);

        System.out.println(personInfo.get(passportInfo).equals(personInfo.get(passportInfo2)));
    }
}
