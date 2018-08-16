package com.epam.mentoring.lectures.lecture4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/20/2018
 */


public class Demo {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.data = 100;
        p.testParent();

        Child c = new Child();
        c.data = 1000;

        p.testParent();

        NewChild nc = new NewChild();
        nc.testParent();

        c.testChild();
    }
}
