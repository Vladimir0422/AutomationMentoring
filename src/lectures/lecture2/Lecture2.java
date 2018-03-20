package lectures.lecture2;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/13/2018
 */


public class Lecture2 {

    public static void main(String[] args) {
        int number = 9;
        sorting(number);

    }

    public static void sorting(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int f = number; f > i; f--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

