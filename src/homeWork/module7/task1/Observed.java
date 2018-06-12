package homeWork.module7.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/11/2018
 */


interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
