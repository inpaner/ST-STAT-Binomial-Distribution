package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Binomial;

public class OutputTable extends JScrollPane {
    JTable table;
    DefaultTableModel model;
    
    public OutputTable() {
        initComponents();
        addComponents();
    }
    
    private void initComponents() {
        table = new JTable(new DefaultTableModel());
    }
    
    private void addComponents() {
        add(table);
    }
    
    public void updateData(Binomial binomial) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(1);
        model.setColumnCount(binomial.getEnd() - binomial.getStart() + 1);
    }
}
