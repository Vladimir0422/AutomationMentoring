package homeWork.module5.task2;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/12/2018
 */


public class Passport {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (number != passport.number) return false;
        return series.equals(passport.series);
    }

    @Override
    public int hashCode() {
        int result = series.hashCode();
        result = 31 * result + number;
        return result;
    }

    String series;
    int number;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    Passport(){

    }

    public void printPassportInfo() {
        System.out.println("Series of passport is " + getSeries() + " and number is " + getNumber());
    }
}
