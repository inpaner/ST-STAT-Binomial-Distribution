package model;

import org.apache.commons.math3.util.ArithmeticUtils;


public class Binomial {
    private double[] probabilities;    
    
    public Binomial(int x, int n, double p) {
        double[] probabilities = new double[1];
        probabilities[0] = solveProbability(x, n, p);
    }
    
    public Binomial(int xStart, int xEnd, int n, double p) {
        double[] probabilities = new double[xEnd - xStart+1];
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
}

