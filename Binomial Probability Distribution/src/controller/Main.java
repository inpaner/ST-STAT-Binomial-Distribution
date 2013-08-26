package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Binomial;

import view.InputPanel;
import view.MainFrame;
import view.MainPanel;
import view.OutputTable;

public class Main {
    private MainPanel mainPanel;
    private InputPanel inputPanel;
    private OutputTable outputTable;
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        MainFrame frame = new MainFrame();
        mainPanel = new MainPanel();
        frame.setPanel(mainPanel);
        inputPanel = mainPanel.getInputPanel();
        outputTable = mainPanel.getOutputTable();
        inputPanel.addUpdateListener(update());
        inputPanel.addLowerSpinnerListener(lowerSpinner());
    }
    
    private ActionListener update() {
        return new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ev) {
            updateOutputs(inputPanel.getXLower(),
                         inputPanel.getXUpper(),
                         inputPanel.getN(),
                         inputPanel.getP());     
        }
            
        };
    }
    
    private ChangeListener lowerSpinner() {
        return new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            int xLower = inputPanel.getXLower();
            int xUpper = inputPanel.getXUpper();
            int n = inputPanel.getN();
            double p = inputPanel.getP();
            
            System.out.println(xLower + ", " + xUpper + ", " + n + ", " + p );
            if (xLower < 0) {
                xLower = 0;
            }
            
            if (xLower >= xUpper) {
                xUpper = xLower;
                inputPanel.setXUpper(xUpper);
                inputPanel.setXLower(xLower);   
            }
            
            if (xLower >= n) {
                n = xUpper;
                inputPanel.setN(n);
            }
            
            updateOutputs(xLower, xUpper, n, p);
        }
        };
    }
    
    private ChangeListener upperSpinner() {
        return new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            int xLower = inputPanel.getXLower();
            int xUpper = inputPanel.getXUpper();
            int n = inputPanel.getN();
            double p = inputPanel.getP();
            
            System.out.println(xLower + ", " + xUpper + ", " + n + ", " + p );
            if (xLower < 0) {
                xLower = 0;
            }
            
            if (xLower >= xUpper) {
                xUpper = xLower;
                inputPanel.setXUpper(xUpper);
                inputPanel.setXLower(xLower);   
            }
            
            if (xLower >= n) {
                n = xUpper;
                inputPanel.setN(n);
            }
            
            updateOutputs(xLower, xUpper, n, p);
        }
        };
    }
    
    
    
    private boolean verifyValues(int xLower, int xUpper, int n, double p) {
        boolean verified = true;
        
        if (xLower > xUpper || 
                xLower > n ||
                xUpper > n ||
                xLower < 0 ||
                p > 1 ||
                p < 0)
            
            verified = false;
        
        return verified;
    }
    
    private void updateOutputs(int xLower, int xUpper, int n, double p) {
        if (verifyValues(xLower, xUpper, n, p)) {
            Binomial binomial = new Binomial(xLower, xUpper, n, p);
            inputPanel.setBValue(binomial.probability());
            outputTable.updateData(binomial);
        }
    }
    
}
