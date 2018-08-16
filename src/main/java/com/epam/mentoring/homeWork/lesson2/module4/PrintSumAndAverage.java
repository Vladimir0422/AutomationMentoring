package com.epam.mentoring.homeWork.lesson2.module4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/26/2018
 */


public class PrintSumAndAverage {
    public static void main(String[] args) {
        int valueForCalculation = 100;
        printSumAndAverage(valueForCalculation);
    }

    public static void printSumAndAverage(int valueForCalculation) {
        int sum = 0;
        for (int i = 1; i <= valueForCalculation; i++) {
            sum += i;
        }
        int average = sum / valueForCalculation;
        System.out.println("Sum of numbers are " + sum);
        System.out.println("Average value is " + average);
    }
}
