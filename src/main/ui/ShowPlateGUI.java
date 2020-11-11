package ui;

import model.AllPlates;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowPlateGUI {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Your plates");
    JPanel panel = new JPanel();
    String[] header = new String[]{"Plates"};
    DefaultTableModel tableModel;
    JTable table;

    public ShowPlateGUI(AllPlates plates) {

        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        frame.setIconImage(logo.getImage());

        label.setBounds(0,0,100,75);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("MV Boli",Font.PLAIN,15));

        panel.setBounds(0,0,200,300);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x071C4B),4));


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

        frame.setVisible(true);
        frame.setSize(300,600);
        frame.setResizable(true);
        panel.setBackground(new Color(0x123456));
        panel.add(label);
        panel.add(table);
        frame.add(panel);


    }

}
