package homeWork.module7.task1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/11/2018
 */


public class DateTime implements Observed {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(new Date());
        }
    }
}

