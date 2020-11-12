package ui;

import model.AllPlates;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowPlateGUI {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    String[] header = new String[]{"Plates"};
    DefaultTableModel tableModel;
    JTable table;

    public ShowPlateGUI(AllPlates plates) {

        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        frame.setIconImage(logo.getImage());

        panel.setBounds(0,0,200,300);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x071C4B),4));

        table(plates);
        frame.setVisible(true);
        frame.setSize(100,600);
        frame.setResizable(false);
        panel.setBackground(new Color(0x123456));
        frame.add(panel);

    }

    private void table(AllPlates plates) {
        table = new JTable();
        tableModel = new DefaultTableModel(header,0);
        table.setModel(tableModel);
        tableModel.setRowCount(0);
        tableModel.addRow(header);
        for (int i = 0; i < plates.getLp().size(); i++) {
            Object[] create = {plates.getLp().get(i).getPlate()};
            tableModel.addRow(create);
        }
        table.setVisible(true);
        panel.add(table);
    }


}
