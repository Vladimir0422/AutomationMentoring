/**
 * SupplyOn CONFIDENTIAL
 * __________________
 * <p/>
 * [2015] - [2020] SupplyOn AG
 * All Rights Reserved.
 * <p/>
 * NOTICE:  All information contained herein is, and remains
 * the property of SupplyOn AG.
 * The intellectual and technical concepts contained
 * herein are proprietary to SupplyOn AG and
 * may be covered by European and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from SupplyOn AG.
 * <p/>
 * Created by : Volodymyr_Silitskyi
 * Created at : 3/6/2018
 */


public class EQSolver {
        public static void main(String[] args) {
            double a = 2;
            double b = -8;
            double c = -24;

            double x1;
            double x2;

            x1 = (-b + (Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            x2 = (-b - (Math.sqrt(b * b - 4 * a * c)) / (2 * a));

            System.out.println("Result is " + x1);
            System.out.println("Result is " + x2);
        }

}
