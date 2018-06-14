package homeWork.module7.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/11/2018
 */


public class DisplayTimeServer {
    public static void main(String[] args) throws InterruptedException {
        Server server1 = new ServerImplOne();
        Server server2 = new ServerImplTwo();
        Client client1 = new ClientOne();
        Client client2 = new ClientTwo();

        server1.addObserver(client1);
        server2.addObserver(client2);
        for (int i = 0; i < 5; i++) {
            server1.notifyObservers();
            server2.notifyObservers();
            Thread.sleep(2000);
        }
    }
}