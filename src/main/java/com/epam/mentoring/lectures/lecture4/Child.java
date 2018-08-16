package com.epam.mentoring.lectures.lecture4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/20/2018
 */


public class Child extends Parent {

    int data;

    public void testChild() {
        System.out.println("Child");
        System.out.println(data);
        System.out.println(super.data);

    }
}
