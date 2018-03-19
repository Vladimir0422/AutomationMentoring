package lectures.lecture2;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/13/2018
 */


public class Lecture2 {

    public static void main(String[] args) {
        int i;
        int j;
        int f;
        
        for (i = 1; i <= 7; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (f = 7; f > i; f--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

