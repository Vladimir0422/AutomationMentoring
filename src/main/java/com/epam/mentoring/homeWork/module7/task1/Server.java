package com.epam.mentoring.homeWork.module7.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/11/2018
 */


interface Server {
    void addObserver(Client o);

    void removeObserver(Client o);

    void notifyObservers();
}

