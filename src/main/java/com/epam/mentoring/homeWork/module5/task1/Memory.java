package com.epam.mentoring.homeWork.module5.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/10/2018
 */


public class Memory {
    private double valueForMemory;

    public double getValueForMemory() {
        return this.valueForMemory;
    }

    public void setValueForMemory(double valueForMemory) {
        this.valueForMemory = valueForMemory;
    }

    public void clearMemory() {
        this.valueForMemory = 0;
    }

    public double addToMemory(double valueInMemory, double resultOfCalculation) {
        return valueInMemory + resultOfCalculation;
    }

    public double subtractFromMemory(double valueInMemory, double resultOfCalculation) {
        return valueInMemory - resultOfCalculation;
    }

    public double calculateMemory(double valueInMemory, double resultOfCalculation) {
        return valueInMemory + resultOfCalculation;
    }
}
