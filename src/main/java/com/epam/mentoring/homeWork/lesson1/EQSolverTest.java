package com.epam.mentoring.homeWork.lesson1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 7/30/2018
 */


public class EQSolverTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintExpectedMessageIfResultMoreThanZero() {
        EQSolver.calculate(1.0, -8.0, 12.0, 16.0);
        assertEquals("Result is 10.0\r\nResult is 6.0\r\n", outContent.toString());
    }

    @Test
    public void shouldPrintExpectedMessageIfResultEqualsToZero() {
        EQSolver.calculate(2, 0, 0, 0);
        assertEquals("Result is -0.0\r\n", outContent.toString());
    }

    @Test
    public void shouldPrintExpectedMessageIfResultLessThanZero() {
        EQSolver.calculate(-2, 1, -18, -178);
        assertEquals("There is no solutions\r\n", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}