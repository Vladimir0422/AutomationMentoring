package com.epam.mentoring.homeWork.module5.task3;

import java.util.Scanner;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/11/2018
 */


public class LinkedList {
    public static void main(String args[]) {
        Scanner inputValue = new Scanner(System.in);

        WorkWithLinkedList list = new WorkWithLinkedList();

        String answer;

        do {
            System.out.println("Enter '1' for inserting value at beginning");

            System.out.println("Enter '2' for inserting value at end");

            System.out.println("Enter '3' for inserting value at position");

            System.out.println("Enter '4' for deleting value at position");

            System.out.println("Enter '5' for getting element by index");

            System.out.println("Enter '6' for getting size");


            int choice = inputValue.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter integer element to insert");

                    list.insertAtStart(inputValue.nextInt());

                    break;

                case 2:

                    System.out.println("Enter integer element to insert");

                    list.insertAtEnd(inputValue.nextInt());

                    break;

                case 3:

                    System.out.println("Enter integer element to insert");

                    int number = inputValue.nextInt();

                    System.out.println("Enter position");

                    int position = inputValue.nextInt();

                    if (position <= 1 || position > list.getSize())

                        System.out.println("Invalid position\n");

                    else

                        list.insertAtPos(number, position);

                    break;

                case 4:

                    System.out.println("Enter position");

                    int positionForDelete = inputValue.nextInt();

                    if (positionForDelete < 1 || positionForDelete > list.getSize())

                        System.out.println("Invalid position\n");

                    else

                        list.deleteAtPos(positionForDelete);

                    break;

                case 5:

                    System.out.println("Please enter index in range 0  to " + (list.size - 1));

                    int index = inputValue.nextInt();

                    list.getElement(index);
                    break;

                case 6:

                    System.out.println("Size = " + list.getSize() + " \n");

                    break;

                default:

                    System.out.println("Wrong Entry \n ");
            }


            list.display();

            System.out.println("If you want finish, type 'End' or 'No' if not");

            answer = inputValue.next();

        } while (!(answer.equals("End")));
    }
}

