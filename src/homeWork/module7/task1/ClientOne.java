package homeWork.module7.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/14/2018
 */


public class ClientOne implements Client {
    @Override
    public void handleEvent(String currentDate) {
        System.out.println("Current date for client one is " + currentDate);
    }
}
