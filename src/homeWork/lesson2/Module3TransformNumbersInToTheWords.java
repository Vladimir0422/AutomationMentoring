package homeWork.lesson2;

import static homeWork.lesson2.BubbleSorting.getNumberForLooking;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/26/2018
 */


public class Module3TransformNumbersInToTheWords {
    private static final String[] TRANSFORMED_NUMBERS = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    public static void main(String[] args) {
        transformNumbersInToTheWords();
    }

    public static void transformNumbersInToTheWords() {
        int numberForTransforming = getNumberForLooking() - 1;
        if (numberForTransforming > 0 && numberForTransforming <= 9) {
            System.out.println(TRANSFORMED_NUMBERS[numberForTransforming]);
        }else{
            System.out.println("There is no such number. Please enter number in range 1 to 9");
        }
    }
}
