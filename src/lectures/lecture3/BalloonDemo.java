package lectures.lecture3;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/16/2018
 */


public class BalloonDemo {
    public static void main(String[] args) {
        Balloon b1 = new Balloon();

        b1.up();
        b1.up();
        b1.down();
        b1.down();

        System.out.println(b1.getAltitude());
    }
}
