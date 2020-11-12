package ui;

import model.AllPlates;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowPlateGUI {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    String[] header = new String[]{"#","Plates"};
    DefaultTableModel tableModel;
    JTable table;
    JLabel numberOfPlates;

    public ShowPlateGUI(AllPlates plates) {
        setNumberOfPlatesLabel(plates);

        ImageIcon logo = new ImageIcon("./data/LicensePlateManagerAppLogo.png");
        frame.setIconImage(logo.getImage());

        panel.setBounds(0,0,200,300);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x071C4B),4));

        table(plates);

        frame.setTitle("Your Plates");
        frame.setVisible(true);
        frame.setSize(302,600);
        frame.setResizable(true);
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
            Object[] createRow = {i + 1,plates.getLp().get(i).getPlate()};
            tableModel.addRow(createRow);
        }
        panel.add(table);
    }

    private void setNumberOfPlatesLabel(AllPlates plates) {
        numberOfPlates = new JLabel();
        numberOfPlates.setText("Number of plates: " + plates.getLp().size());
        numberOfPlates.setHorizontalTextPosition(JLabel.CENTER);
        numberOfPlates.setVerticalTextPosition(JLabel.BOTTOM);
        numberOfPlates.setForeground(Color.white);
        numberOfPlates.setFont(new Font("MV Boli",Font.PLAIN,15));
        numberOfPlates.setVerticalAlignment(JLabel.TOP);
        numberOfPlates.setHorizontalAlignment(JLabel.CENTER);
        panel.add(numberOfPlates);
    }

}
