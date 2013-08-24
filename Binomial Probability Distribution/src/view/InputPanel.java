package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.crypto.spec.PSource.PSpecified;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import org.apache.commons.math3.genetics.NPointCrossover;

import net.miginfocom.swing.MigLayout;

public class InputPanel extends JPanel {
    private final int X_UPPER_LIMIT = 100000; // 100,000
    
    private JLabel xLabel;
    private JSpinner xLowerSpinner;
    private JLabel toLabel;
    private JSpinner xUpperSpinner;
    private JLabel nLabel;
    private JSpinner nSpinner;
    private JLabel pLabel;
    private JTextField pField;
    private JSlider pSlider;
    private JButton updateButton;
    private JLabel bLabel;
    private JLabel bValueLabel;
    
    public InputPanel() {
        setLayout(new MigLayout("", "[][30][30, center][30]"));
        initComponents();
        addComponents();
    }
    
    private void initComponents() {                                
        // x
        xLabel = new JLabel("x: ");
        xLowerSpinner = new JSpinner(new SpinnerNumberModel(0, 0, X_UPPER_LIMIT, 1));
        JComponent field = ((JSpinner.DefaultEditor) xLowerSpinner.getEditor());
        Dimension prefSize = field.getPreferredSize();
        prefSize = new Dimension(30, prefSize.height);
        field.setPreferredSize(prefSize);
        
        toLabel = new JLabel("to: ");
        
        xUpperSpinner = new JSpinner(new SpinnerNumberModel(0, 0, X_UPPER_LIMIT, 1));
        field = ((JSpinner.DefaultEditor) xUpperSpinner.getEditor());
        prefSize = field.getPreferredSize();
        prefSize = new Dimension(30, prefSize.height);
        field.setPreferredSize(prefSize);
        
        // n
        nLabel = new JLabel("n: ");
        nSpinner = new JSpinner(new SpinnerNumberModel(0, 0, X_UPPER_LIMIT, 1));
        field = ((JSpinner.DefaultEditor) nSpinner.getEditor());
        prefSize = field.getPreferredSize();
        prefSize = new Dimension(30, prefSize.height);
        field.setPreferredSize(prefSize);
        
        // p
        pLabel = new JLabel("p: ");
        pField = new JTextField(6);
        pField.setHorizontalAlignment(JTextField.RIGHT);
        pSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);
        
        // b
        updateButton = new JButton("Update Values");
        bLabel = new JLabel("b: ");
        bValueLabel = new JLabel("");
    }
    
    private void addComponents() {
        add(xLabel);
        add(xLowerSpinner);
        add(toLabel);
        add(xUpperSpinner, "wrap");
        
        add(nLabel);
        add(nSpinner, "wrap");
        
        add(pLabel);
        add(pField, "span, split");
        add(pSlider, "wrap 30");
        
        add(updateButton, "span, split, wrap");
        
        add(bLabel);
        add(bValueLabel);
    }
    
    public void setBValue(String value) {
        bValueLabel.setText(value);
    }
    
    public int getXLower() {
        return (Integer) xLowerSpinner.getValue();
    }
    
    public int getXUpper() {
        return (Integer) xUpperSpinner.getValue();
    }
    
    public double getP() {
        return Double.valueOf(pLabel.getText()) / 1000;
    }
    
    public double getN() {
        return (Integer) nSpinner.getValue();
    }
    
    
    //--------------------------------
    // Listeners
    
    public void addUpdateListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }
    
    public void addLowerSpinnerListener(ChangeListener listener) {
        xLowerSpinner.addChangeListener(listener);
    }
    
    public void addUpperSpinnerListener(ChangeListener listener) {
        xUpperSpinner.addChangeListener(listener);
    }
    
    public void addNSpinnerListener(ChangeListener listener) {
        nSpinner.addChangeListener(listener);
    }
    
    public void addpSliderListener(ChangeListener listener) {
        pSlider.addChangeListener(listener);
    }
}
