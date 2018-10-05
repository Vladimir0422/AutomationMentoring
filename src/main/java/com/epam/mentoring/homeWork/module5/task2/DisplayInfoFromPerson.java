package com.epam.mentoring.homeWork.module5.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/8/2018
 */


public class DisplayInfoFromPerson {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayInfoFromPerson.class);

    public static void main(String[] args) {
        HashMap<Passport, Person> personInfo = new HashMap<Passport, Person>();

        Person firstPerson = Person.newBuilder()
                .setName("Vova")
                .setSurname("Sil")
                .setEmail("email@com")
                .setGender(Gender.MALE)
                .setHobby(Hobby.SWIMMING)
                .setPet(Pet.CAT)
                .setNumberOfChildren(0)
                .build();
        LOGGER.info(firstPerson.toString());
        try {
            ValidationModule.validate(firstPerson);
        } catch (IllegalArgumentException e) {
            LOGGER.warn(e.getMessage());
        }
        StatisticsModule.addPerson(firstPerson);

        Person secondPerson = Person.newBuilder()
                .setName("Vova2")
                .setSurname("Sil2")
                .setEmail("email2@com")
                .setGender(Gender.MALE)
                .setHobby(Hobby.DANCING)
                .setPet(Pet.BIRD)
                .setNumberOfChildren(3)
                .build();
        LOGGER.info(secondPerson.toString());
        try {
            ValidationModule.validate(secondPerson);
        } catch (IllegalArgumentException e) {
            LOGGER.warn(e.getMessage());
        }
        StatisticsModule.addPerson(secondPerson);

        Person thirdPerson = Person.newBuilder()
                .setName("Vova3")
                .setSurname("Sil3")
                .setEmail("email3@com")
                .setGender(Gender.MALE)
                .setHobby(Hobby.GAMING)
                .setPet(Pet.CAT)
                .setNumberOfChildren(-2)
                .build();
        LOGGER.info(thirdPerson.toString());
        try {
            ValidationModule.validate(thirdPerson);
        } catch (IllegalArgumentException e) {
            LOGGER.warn(e.getMessage());
        }
        StatisticsModule.addPerson(thirdPerson);
        StatisticsModule.logStatistics();

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
