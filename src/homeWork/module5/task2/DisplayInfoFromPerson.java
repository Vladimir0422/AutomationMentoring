package homeWork.module5.task2;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/8/2018
 */


public class DisplayInfoFromPerson {
    public static void main(String[] args) {
        Person firstPerson = new Person("FirstPersonName", "FirstPersonSurname", "FirstPersonEmail");
        Person secondPerson = new Person();


        secondPerson.setName("Vova");
        secondPerson.setSurname("Sil");
        secondPerson.setEmail("email@com");

        firstPerson.printInfo();
        secondPerson.printInfo();
    }
}
