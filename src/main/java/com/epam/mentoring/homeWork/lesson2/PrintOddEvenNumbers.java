package com.epam.mentoring.homeWork.lesson2;

import static com.epam.mentoring.homeWork.lesson2.BubbleSorting.getNumberForLooking;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/26/2018
 */


public class PrintOddEvenNumbers {
    public static void main(String[] args) {
        int number = getNumberForLooking();
        oddEvenNumber(number);
    }
    public static void oddEvenNumber(int number) {
        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
}
