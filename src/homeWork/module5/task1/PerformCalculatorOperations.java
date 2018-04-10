package homeWork.module5.task1;

import java.util.Scanner;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/6/2018
 */


public class PerformCalculatorOperations {

    public static double enterValue() {
        System.out.println("Please enter some number");
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public static char enterOperator() {
        boolean flag = true;
        char act = 0;
        while (flag) {
            System.out.println("Enter operator (+, -, *, /)");
            Scanner action = new Scanner(System.in);
            act = action.next().charAt(0);

            if (!(act == '+' || act == '-' || act == '*' || act == '/')) {
                System.out.println("Operator " + act + " is not acceptable. Please use one of this operators (+, -, *, /)");
                flag = true;
            } else
                flag = false;
        }
        return act;
    }

    public static String selectOperatorForMemory() {
        System.out.println("If you want to work with selectOperatorForMemory, enter some operator (e.g. M+, M-, MR), or enter 'End'");
        Scanner action = new Scanner(System.in);
        return action.next();
    }

    public static double calculation() {
        boolean flag = true;
        double resultOfCalculation = 0;
        double valueInMemory = 0;

        while (flag) {
            double input1 = enterValue();
            char act = enterOperator();
            double input2 = enterValue();
            if (act == '+') {
                resultOfCalculation = input1 + input2;
                System.out.println(input1 + " + " + input2 + " = " + resultOfCalculation);
            } else if (act == '-') {
                resultOfCalculation = input1 - input2;
                System.out.println(input1 + " - " + input2 + " = " + resultOfCalculation);
            } else if (act == '*') {
                resultOfCalculation = input1 * input2;
                System.out.println(input1 + " * " + input2 + " = " + resultOfCalculation);
            } else if (act == '/') {
                resultOfCalculation = input1 / input2;
                System.out.println(input1 + " / " + input2 + " = " + resultOfCalculation);
            } else if (act != '+' || act != '-' || act != '+' || act != '*' || act != '/') {
                System.out.println("Operator " + act + " is not acceptable. Please use one of this operators (+, -, *, /)");
            }

            //Work with selectOperatorForMemory
            String memory = selectOperatorForMemory();
            Memory workWithMemory = new Memory();
            if (memory.equals("M+")) {
                valueInMemory = valueInMemory + resultOfCalculation;
                workWithMemory.setValueForMemory(valueInMemory);
                System.out.println("Value for M+ is " + workWithMemory.getValueForMemory());
                flag = true;
            } else if (memory.equals("M-")) {
                valueInMemory = valueInMemory - resultOfCalculation;
                workWithMemory.setValueForMemory(valueInMemory);
                System.out.println("Value for M- is " + workWithMemory.getValueForMemory());
                flag = true;
            } else if (memory.equals("MR")) {
                valueInMemory = valueInMemory + resultOfCalculation;
                workWithMemory.setValueForMemory(valueInMemory);
                System.out.println("Value for MR is " + workWithMemory.getValueForMemory());
                flag = true;
            } else if (memory.equals("MC")){
                workWithMemory.clearMemory();
                System.out.println("Memory is clear. Value is " + workWithMemory.getValueForMemory());
            }else if (memory.equals("End")) {
                System.out.println("Calculator is off");
                flag = false;
            }
        }
        return resultOfCalculation;
    }
}

