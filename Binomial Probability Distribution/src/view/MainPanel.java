package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Binomial;
import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {
    private InputPanel inputPanel;
    private JTabbedPane tabbedPane;
    private OutputTable outputTable;
    
    public MainPanel() {
        setLayout(new MigLayout());
        initComponents();
        addComponents();
    }
    
    private void initComponents() {
        inputPanel = new InputPanel();
        tabbedPane = new JTabbedPane();
        outputTable = new OutputTable();
        tabbedPane.addTab("Table", outputTable);
        Binomial binomial = new Binomial(3, 20, 20, 0.3);
        outputTable.updateData(binomial);
    }
    
    private void addComponents() {
        add(inputPanel, "wrap");
        add(tabbedPane, "span, split");
    }
    
    public InputPanel getInputPanel() {
        return inputPanel;
    }
    
    public OutputTable getOutputTable() {
        return outputTable;
    }
}
