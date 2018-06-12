package homeWork.module7.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/11/2018
 */


public class DisplayTime {
    public static void main(String[] args) throws InterruptedException {
        DateTime server1 = new DateTime();
        DateTime server2 = new DateTime();
        Client client1 = new Client();
        Client client2 = new Client();

        server1.addObserver(client1);
        server2.addObserver(client2);
        for (int i = 0; i < 5; i++) {
            server1.notifyObservers();
            server2.notifyObservers();
            Thread.sleep(2000);
        }
    }
}