package homeWork.lesson2.module4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/26/2018
 */


public class FindPiValue {
    public static void main(String[] args) {
        int accuracy = 500000;
        calculatePi(accuracy);
    }

    public static void calculatePi(int accuracy) {
        double resultPi;
        double formula = 0;

        for (int i = 1; i < accuracy; i +=2) {
            formula = formula + ((1.0 / (2.0 * i - 1)) - (1.0 / (2.0 * i + 1)));
        }

        resultPi = 4 * formula;

        System.out.printf("%.10f%n", resultPi);
        System.out.println(Math.PI);
    }
}
