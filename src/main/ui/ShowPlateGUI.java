package ui;

import model.AllPlates;

import javax.swing.*;
import java.awt.*;

public class ShowPlateGUI {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Your plates");
    JPanel panel = new JPanel();


    ShowPlateGUI(AllPlates plates) {
        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        frame.setIconImage(logo.getImage());

        label.setBounds(0,0,100,75);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("MV Boli",Font.PLAIN,15));

        panel.setBounds(0,0,200,300);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x071C4B),4));

        frame.setVisible(true);
        frame.setSize(300,600);
        frame.setResizable(false);
        panel.setBackground(new Color(0x123456));
        frame.add(panel);
        panel.add(label);

    }

}
