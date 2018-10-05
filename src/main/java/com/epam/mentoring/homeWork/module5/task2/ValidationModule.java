package com.epam.mentoring.homeWork.module5.task2;


import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 9/3/2018
 */


public class ValidationModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    public static void validate(Person person) {
        verifyGender(person.getGender());
        verifyPet(person.getPet());
    }

    private static void verifyGender(Gender gender) {
        if (EnumUtils.isValidEnum(Gender.class, gender.name())) {
            LOGGER.info("Gender " + gender + " was saved");
        } else {
            throw new IllegalArgumentException("Gender " + gender + " is invalid");
        }
    }

    private static void verifyPet(Pet pet) {
        if (EnumUtils.isValidEnum(Pet.class, pet.name())) {
            LOGGER.info("pet " + pet + " was saved");
        } else {
            throw new IllegalArgumentException("Pet " + pet + " is invalid");
        }
    }
}
