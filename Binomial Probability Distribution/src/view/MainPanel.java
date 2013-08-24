package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {
    private InputPanel inputPanel;
    
    public MainPanel() {
        setLayout(new MigLayout());
        initComponents();
        addComponents();
    }
    
    private void initComponents() {
        inputPanel = new InputPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
    }
    
    private void addComponents() {
        add();
    }
}
