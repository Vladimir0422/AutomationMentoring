package homeWork.lesson2.module4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/26/2018
 */


public class SumOfRow {
    public static void main(String[] args) {
        double result = 0;
        int n = 50000;

        printSumOfRow(result, n);
    }

    public static void printSumOfRow(double result, int n) {
        for (int i = 1; i <= n; i++) {
            result = result + (double) 1 / i;
        }
        System.out.println(result);
    }
}
