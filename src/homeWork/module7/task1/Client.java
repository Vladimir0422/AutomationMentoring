package homeWork.module7.task1;

import java.util.Date;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/11/2018
 */


public class Client implements Observer {
    public void handleEvent(Date currentDate) {
        System.out.println("Current date is " + currentDate);
    }
}
