package model;

import org.apache.commons.math3.util.ArithmeticUtils;

public class Binomial {
    public static void main(String[] args) {
        double p = Binomial.summatedProbability(3, 8, 15, 0.4);
        System.out.println(p);
    }
    
    public static double probability(int x, int n, double p) {
        return (double) (combination(n, x) * Math.pow(p, x) * Math.pow(1-p, n-x)); 
    }
    
    public static double[] separatedProbability(int xStart, int xEnd, int n, double p) {
        double[] probabilities = new double[xEnd - xStart];
        int index = 0;
        
        for (int i = xStart; i <= xEnd; i++) {
            probabilities[index] = probability(i, n, p);
            index++;
        }
        
        return probabilities;
    }
    
    public static double summatedProbability(int xStart, int xEnd, int n, double p) {
        double[] probabilities = separatedProbability(xStart, xEnd, n, p);
        
        float summation = 0;
        for (double prob : probabilities) {
            summation += prob;
        }
        
        return summation;
    }
    
    private static long combination(int n, int r) {
        return ArithmeticUtils.factorial(n) / 
                (ArithmeticUtils.factorial(r) * ArithmeticUtils.factorial(n - r)); 
    }
}
