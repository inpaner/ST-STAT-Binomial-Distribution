package model;

import org.apache.commons.math3.util.ArithmeticUtils;


public class Binomial {
    private double[] probabilities;    
    private int start;
    private int end;
    private int n;
    private double p;
    
    public Binomial(int x, int n, double p) {
        this(x, x, n, p);
    }
    
    public Binomial(int xStart, int xEnd, int n, double p) {
        start = xStart;
        end = xEnd;
        this.n = n;
        this.p = p;
        probabilities = new double[xEnd - xStart+1];
        int index = 0;
        
        for (int i = xStart; i <= xEnd; i++) {
            probabilities[index] = solveProbability(i, n, p);
            index++;
        }
    }
    
    private double solveProbability(int x, int n, double p) {
        return (double) (combination(n, x) * Math.pow(p, x) * Math.pow(1-p, n-x));
    }
    
    public double probability() {
        float summation = 0;
        for (double prob : probabilities) {
            summation += prob;
        }
        
        return summation;
    }
    
    public double[] probabilities() {
        return probabilities;
    }

    private static long combination(int n, int r) {
        return ArithmeticUtils.factorial(n) /
                (ArithmeticUtils.factorial(r) * ArithmeticUtils.factorial(n - r));
    }
    
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getN() {
        return n;
    }

    public double getP() {
        return p;
    }
    
}

