package homeWork.module7.task1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/14/2018
 */


public class ServerImplTwo implements Server {
    Date currentDate = new Date();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd MMMM h:m", Locale.CHINESE);
    List<Client> observers = new ArrayList<>();

    public void addObserver(Client o) {
        observers.add(o);
    }

    public void removeObserver(Client o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Client o : observers) {
            o.handleEvent(dateFormat2.format(currentDate));
        }
    }
}
