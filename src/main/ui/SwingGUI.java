package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon (lines 16-18
public class SwingGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JLabel labelWelcomeHeader;
        JPanel panel;
        //images: imported and resized
        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        frame.setIconImage(logo.getImage());
        ImageIcon platePic = new ImageIcon("AddLicensePlate.png");
        Image image = platePic.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        platePic = new ImageIcon(newimg);
        Border border = BorderFactory.createLineBorder(new Color(0x071C4B),4);

        //texts: label for the heading of the application
        labelWelcomeHeader = new JLabel();
        labelWelcomeHeader.setText("Welcome to License Plate Manager!");
        labelWelcomeHeader.setIcon(platePic);
        labelWelcomeHeader.setHorizontalTextPosition(JLabel.CENTER);
        labelWelcomeHeader.setVerticalTextPosition(JLabel.BOTTOM);
        labelWelcomeHeader.setForeground(Color.white);
        labelWelcomeHeader.setFont(new Font("MV Boli",Font.PLAIN,15));
        labelWelcomeHeader.setIconTextGap(-10);
        labelWelcomeHeader.setBorder(border);
        labelWelcomeHeader.setVerticalAlignment(JLabel.TOP);
        labelWelcomeHeader.setHorizontalAlignment(JLabel.CENTER);
        frame.add(labelWelcomeHeader);

        //panel:
        panel = new JPanel();
        panel.setBackground(new Color(0x00000));
        panel.setBounds(0,0,1,1);

        //color of the background, title of the application and overall gui design. no method calls;
        frame.setTitle("License Plate Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(450,600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.add(panel);
    }

}
