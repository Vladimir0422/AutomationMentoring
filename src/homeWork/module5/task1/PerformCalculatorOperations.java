package homeWork.module5.task1;

import java.util.Scanner;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/6/2018
 */


public class PerformCalculatorOperations {

//    private static double enterValue() {
//        System.out.println("Please enter some number");
//        Scanner input = new Scanner(System.in);
//        return input.nextDouble();
//    }
//
//    private static char enterOperator() {
//        boolean flag = true;
//        char act = 0;
//        while (flag) {
//            System.out.println("Enter operator (+, -, *, /)");
//            Scanner action = new Scanner(System.in);
//            act = action.next().charAt(0);
//
//            if (!(act == '+' || act == '-' || act == '*' || act == '/')) {
//                System.out.println("Operator " + act + " is not acceptable. Please use one of this operators (+, -, *, /)");
//                flag = true;
//            } else
//                flag = false;
//        }
//        return act;
//    }

    private static String selectOperatorForMemory() {
        System.out.println("If you want to work with selectOperatorForMemory, enter some operator (e.g. M+, M-, MR), or enter 'End'");
        Scanner action = new Scanner(System.in);
        return action.next();
    }

    public static double add(double input1, double input2) {
        return input1 + input2;
    }

    public static double subtract(double input1, double input2) {
        return input1 - input2;
    }

    public static double multiply(double input1, double input2) {
        return input1 * input2;
    }

    public static double divide(double input1, double input2) {
        return input1 / input2;
    }

    public static double calculation(double input1, char operator, double input2) {

        double resultOfCalculation = 0;
        double valueInMemory = 0;

            if (operator == '+') {
                resultOfCalculation = add(input1, input2);
                System.out.println(input1 + " + " + input2 + " = " + resultOfCalculation);
            } else if (operator == '-') {
                resultOfCalculation = subtract(input1, input2);
                System.out.println(input1 + " - " + input2 + " = " + resultOfCalculation);
            } else if (operator == '*') {
                resultOfCalculation = multiply(input1, input2);
                System.out.println(input1 + " * " + input2 + " = " + resultOfCalculation);
            } else if (operator == '/') {
                resultOfCalculation = divide(input1, input2);
                System.out.println(input1 + " / " + input2 + " = " + resultOfCalculation);
            } else if (operator != '+' || operator != '-' || operator != '+' || operator != '*' || operator != '/') {
                System.out.println("Operator " + operator + " is not acceptable. Please use one of this operators (+, -, *, /)");
            }

//            Work with selectOperatorForMemory
            String memoryOperator = selectOperatorForMemory();
            Memory workWithMemory = new Memory();
            if (memoryOperator.equals("M+")) {
                workWithMemory.setValueForMemory(workWithMemory.addToMemory(valueInMemory, resultOfCalculation));
                System.out.println("Value for M+ is " + workWithMemory.getValueForMemory());
            } else if (memoryOperator.equals("M-")) {
                workWithMemory.setValueForMemory(workWithMemory.subtractFromMemory(valueInMemory, resultOfCalculation));
                System.out.println("Value for M- is " + workWithMemory.getValueForMemory());
            } else if (memoryOperator.equals("MR")) {
                workWithMemory.setValueForMemory(workWithMemory.calculateMemory(valueInMemory, resultOfCalculation));
                System.out.println("Value for MR is " + workWithMemory.getValueForMemory());
            } else if (memoryOperator.equals("MC")) {
                workWithMemory.clearMemory();
                System.out.println("Memory is clear. Value is " + workWithMemory.getValueForMemory());
            } else if (memoryOperator.equals("End")) {
                System.out.println("Calculator is off");
            }
        return resultOfCalculation;
    }
}

