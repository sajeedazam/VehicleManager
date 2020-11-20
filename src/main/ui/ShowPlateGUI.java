package ui;

import model.AllPlates;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

//this class acts as a window displaying the number of plates added as well as listing the plates
public class ShowPlateGUI {

    //fields
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private String[] header = new String[]{"#","Plates","Brand","Color","Comment"};
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel numberOfPlates;

    //MODIFIES: frame, panel
    //EFFECTS:  constructs the new window
    public ShowPlateGUI(AllPlates plates) {
        setNumberOfPlatesLabel(plates);

        ImageIcon logo = new ImageIcon("./data/LicensePlateManagerAppLogo.png");
        frame.setIconImage(logo.getImage());

        panel.setBounds(0,0,500,400);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x071C4B),4));

        table(plates);

        frame.setTitle("Your Plates");
        frame.setVisible(true);
        frame.setSize(500,400);
        frame.setResizable(true);
        panel.setBackground(new Color(0x123456));
        frame.add(panel);

    }

    //MODIFIES: table, tableModel, panel
    //EFFECTS:  creates a JTable and a table to display vehicle attributes and the plates
    private void table(AllPlates plates) {
        table = new JTable();
        tableModel = new DefaultTableModel(header,0);
        table.setModel(tableModel);
        tableModel.setRowCount(0);
        tableModel.addRow(header);
        for (int i = 0; i < plates.getLp().size(); i++) {
            for (int j = 0; j < plates.getLp().get(i).getVehicleAttributes().size(); j++) {
                Object[] createRow = {i + 1,plates.getLp().get(i).getPlate(),
                        plates.getLp().get(i).getVehicleAttributes().get(j).getVehicleModel(),
                        plates.getLp().get(i).getVehicleAttributes().get(j).getVehicleColourAndType(),
                        plates.getLp().get(i).getVehicleAttributes().get(j).getVehicleComment()};
                tableModel.addRow(createRow);
            }
        }
        table.setBackground(new Color(0x071C4B));
        table.setForeground(Color.WHITE);
        table.setBorder(BorderFactory.createEtchedBorder());
        table.setFont(new Font("MV Boli",Font.PLAIN,15));
        table.setRowHeight(25);
        table.setEnabled(false);
        panel.add(table);
    }

    //MODIFIES: numberOfPlates, panel
    //EFFECTS:  creates the label for the panel displaying number of plates
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
