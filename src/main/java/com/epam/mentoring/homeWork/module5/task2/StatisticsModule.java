package com.epam.mentoring.homeWork.module5.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 9/3/2018
 */


public class StatisticsModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayInfoFromPerson.class);
    private static final int HERO_PARENTS = 2;
    private static List<Person> listOfPersons = new ArrayList<>();

    public static void addPerson(Person person) {
        listOfPersons.add(person);
    }

    public static void logStatistics() {
        catOwnersCounter();
        parentsHeroesCounter();
    }

    private static void catOwnersCounter() {
        List catOwners = listOfPersons.stream()
                .filter(person -> person.getPet().equals(Pet.CAT))
                .collect(Collectors.toList());
        LOGGER.info(catOwners.size() + " person(s) has/have cat(s)");
    }

    private static void parentsHeroesCounter() {
        List parentsHeroes = listOfPersons.stream()
                .filter(person -> person.getNumberOfChildren() > HERO_PARENTS)
                .collect(Collectors.toList());
        LOGGER.info(parentsHeroes.size() + " parent(s) has/have more than 2 children");
    }
}
