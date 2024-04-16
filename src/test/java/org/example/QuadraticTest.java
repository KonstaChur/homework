package org.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class QuadraticTest {
    Quadratic solver = new Quadratic();
    @Test
    public void testNoRoots() {

        double a = 1;
        double b = 0;
        double c = 1;
        double delta = 0.000001;
        ArrayList<Double> solve = solver.solve(a, b, c, delta);
        assertNotNull(solve);
        assertFalse(solve.isEmpty());

    }
    @Test
    public void testOneRoots() {

        double a = 1;
        double b = 2;
        double c = 1;
        double delta = 0.000001;
        ArrayList<Double> solve = solver.solve(a, b, c, delta);
        assertNotNull(solve);
        assertFalse(solve.size()!=1);
        double x = solve.get(0);
        assertEquals(calculated(a, b, c, x), 0.0, delta);
    }

    @Test
    public void testTwoRoots(){
        double a = 1;
        double b = 0;
        double c = -1;
        double delta = 0.000001;
        ArrayList<Double> solve = solver.solve(a, b, c, delta);
        assertNotNull(solve);
        assertFalse(solve.size()!=2);
        double x1 = solve.get(0);
        double x2 = solve.get(1);
        assertEquals(calculated(a, b, c, x1), 0.0, delta);
        assertEquals(calculated(a, b, c, x2), 0.0, delta);
    }

    @Test()
    public void testNullA() {
        double a = 0.0000005;
        double b = 0;
        double c = -1;
        double delta = 0.000001;
        assertThrows(NullPointerException.class, () -> {
            solver.solve(a, b, c, delta);
        });
    }

    @Test
    public void testSolveInvalidInput() {

        String a = "0.0000005";
        boolean b = false;
        char c = 10;
        double delta = 0.000001;

        assertThrows(ClassCastException.class, () -> {
            solver.solve(a, b, c, delta);
        });
    }

    private double calculated(double a, double b, double c, double x){
        return a * x * x + b * x + c;
    }

}
