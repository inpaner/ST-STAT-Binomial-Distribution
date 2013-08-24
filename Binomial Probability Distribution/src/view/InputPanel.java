package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class InputPanel extends JPanel {
    private final int X_UPPER_LIMIT = 100000; // 100,000
    
    public InputPanel() {
        setLayout(new MigLayout());
        initComponents();
    }
    
    private void initComponents() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                                       0, //min
                                       X_UPPER_LIMIT, //max
                                       1);                //step
        
        JLabel xLabel = new JLabel("x: ");
        JTextField xLowerField = new JTextField(6);
        JSpinner xLowerSpinner = new JSpinner(spinnerModel);
        JLabel toLabel = new JLabel("to: ");
        JTextField xUpperField = new JTextField(6);
        JSpinner xUpperSpinner = new JSpinner(spinnerModel);
        
        JLabel nLabel = new JLabel("n: ");
        JTextField nField = new JTextField(6);
        JSpinner nSpinner = new JSpinner(spinnerModel);
        
        JLabel pLabel = new JLabel("p: ");
        JTextField pField = new JTextField(6);
        JSlider pSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);        
    }
    
    private void addComponents() {
        
    }
}
