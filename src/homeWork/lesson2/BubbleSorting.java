package homeWork.lesson2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/17/2018
 */


public class BubbleSorting {

    public static void main(String[] args) {
        System.out.println("Please enter some number");
        int[] array = {5, 2, 8, 1, 3, 4, 9, 6, 10, 7};
        Scanner input = new Scanner(System.in);
        int numberForLooking = input.nextInt();
        int first = 0;
        int last = array.length - 1;

        bubbleSorting(array);
        boolean result = binarySearch(array, first, last, numberForLooking);
        System.out.println(result);

    }

    public static int[] bubbleSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int newPos = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = newPos;
                }
            }
        }
        System.out.println("Sorted array is " + Arrays.toString(array));
        return array;
    }

    public static boolean binarySearch(int[] array, int first, int last, int numberForLooking) {
        boolean found = false;
//        int position = 0;
        int mid;
        while (first <= last) {
            mid = (first + last) / 2;
            if (numberForLooking < array[mid]) {
                last = mid - 1;
            } else if (numberForLooking > array[mid]) {
                first = mid + 1;
            } else {
                found = true;
//                position = mid;
                break;
            }
        }
//        if (found) {
//            System.out.println(numberForLooking + " is found at index " + position);
//        } else {
//            System.out.println(numberForLooking + " number isn't found in array");
//        }
        return found;
    }
}
