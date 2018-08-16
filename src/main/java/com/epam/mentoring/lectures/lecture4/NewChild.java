package com.epam.mentoring.lectures.lecture4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/20/2018
 */


public class NewChild extends Parent {
    public void testChild() {
        System.out.println("Child");
    }

    public void testParent() {
        System.out.println("Test parent child 2");
        super.testParent();
    }
}
