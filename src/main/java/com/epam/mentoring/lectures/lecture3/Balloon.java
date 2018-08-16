package com.epam.mentoring.lectures.lecture3;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/16/2018
 */


public class Balloon {
    private int color;
    private double velocity;
    private double altitude;

    long id;

    public void up() {
        altitude++;
    }

    public void down() {
        if (altitude > 0) {
            altitude--;
        }
    }

    public double getAltitude(){
        return altitude;
    }

}
