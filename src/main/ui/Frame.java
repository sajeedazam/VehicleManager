package ui;

import model.LicensePlateList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon (lines 29-31)
public class Frame extends JFrame implements ActionListener {


    JLabel labelWelcomeHeader;
    JPanel panel;
    JButton button;
    JTextField textField;

    Frame() {
        //fields
        labelWelcomeHeader = new JLabel();
        panel = new JPanel();
        textField = new JTextField();

        //images: imported and resized
        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        this.setIconImage(logo.getImage());
        ImageIcon platePic = new ImageIcon("AddLicensePlate.png");
        Image image = platePic.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        platePic = new ImageIcon(newimg);
        Border border = BorderFactory.createLineBorder(new Color(0x071C4B),4);

        //text filed for user input
        textField.setBounds(170,100,100,30);


        //texts: label for the heading of the application
        labelWelcomeHeader = new JLabel();
        labelWelcomeHeader.setText("Welcome to License Plate Manager!");
        labelWelcomeHeader.setIcon(platePic);
        labelWelcomeHeader.setHorizontalTextPosition(JLabel.CENTER);
        labelWelcomeHeader.setVerticalTextPosition(JLabel.BOTTOM);
        labelWelcomeHeader.setForeground(Color.white);
        labelWelcomeHeader.setFont(new Font("MV Boli",Font.BOLD,15));
        labelWelcomeHeader.setIconTextGap(-10);
        labelWelcomeHeader.setVerticalAlignment(JLabel.TOP);
        labelWelcomeHeader.setHorizontalAlignment(JLabel.CENTER);
        this.add(labelWelcomeHeader);

        //buttons:
        button = new JButton();
        button.setBounds(193,150,60,30);
        button.addActionListener(this);
        button.setText("Add");
        button.setFont(new Font("MV Boli",Font.PLAIN,15));
        button.setFocusable(false);
        button.setBackground(new Color(0x071C4B));
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createEtchedBorder());

        //panel:
        panel = new JPanel();
        panel.setBackground(new Color(0x123456));
        panel.setBounds(0,0,1,1);
        panel.setLayout(null);
        panel.setBorder(border);

        //color of the background, title of the application and overall gui design. no method calls;
        this.setTitle("License Plate Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450,600);
        this.setVisible(true);
        panel.add(labelWelcomeHeader);
        panel.add(button);
        panel.add(textField);
        this.add(panel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new ShowPlateGUI();
        }
    }
}
