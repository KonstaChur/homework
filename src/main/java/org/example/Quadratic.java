package org.example;

import java.util.ArrayList;

import static java.lang.Double.NaN;

public class Quadratic {

    public ArrayList<Double> solve(Object A, Object B, Object C, Object D) {

        double a= checkDouble(A);
        double b = checkDouble(B);
        double c = checkDouble(C);
        double delta = checkDouble(D);

        ArrayList<Double> solve = new ArrayList<>();
        double d = b * b - 4 * a * c;

        if (Math.abs(a) < delta) {
            throw new NullPointerException("String can not be empty!");
        }
        double x1 = (-1 * b + Math.sqrt(d)) / (2 * a);
        double x2 = (-1 * b - Math.sqrt(d)) / (2 * a);
        if (x1 != NaN) {
            solve.add(x1);
            if (Math.abs(x1 - x2) > delta) {
                solve.add(x2);
            }
        }
        return solve;
    }

    private double checkDouble(Object o){
        if (o instanceof Double){
            return (double) o;
        }else {
            throw new ClassCastException("invalid data type");
        }
    }

}
