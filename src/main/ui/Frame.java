package ui;

import model.AllPlates;
import model.LicensePlateList;
import persistance.JsonReader;
import persistance.JsonWriter;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon (lines 48-51)
public class Frame extends JFrame implements ActionListener {

    //fields
    AllPlates plates = new AllPlates();
    LicensePlateList licensePlateList;
    JsonWriter jsonWriter;
    JsonReader jsonReader;
    JLabel labelWelcomeHeader;
    JPanel panel;
    JButton addPlateButton;
    JTextField textField;
    JRadioButton display;
    JRadioButton load;
    JRadioButton save;
    ButtonGroup buttonGroup;

    Frame() {
        //initializations
        labelWelcomeHeader = new JLabel();
        panel = new JPanel();
        textField = new JTextField();
        display = new JRadioButton();
        load = new JRadioButton();
        save = new JRadioButton();
        addPlateButton = new JButton();
        buttonGroup = new ButtonGroup();
        jsonReader = new JsonReader("./data/LicensePlateManager.json");
        jsonWriter = new JsonWriter("./data/LicensePlateManager.json");

        //images: imported and resized
        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        this.setIconImage(logo.getImage());
        ImageIcon platePic = new ImageIcon("AddLicensePlate.png");
        Image image = platePic.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        platePic = new ImageIcon(newimg);
        Border border = BorderFactory.createLineBorder(new Color(0x071C4B),4);
        ImageIcon displayIcon = new ImageIcon("DisplayButton.png");
        Image image0 = displayIcon.getImage();
        Image newimg0 = image0.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        displayIcon = new ImageIcon(newimg0);
        ImageIcon loadIcon = new ImageIcon("LoadButton.png");
        Image image1 = loadIcon.getImage();
        Image newimg1 = image1.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH);
        loadIcon = new ImageIcon(newimg1);
        ImageIcon saveIcon = new ImageIcon("SaveButton.png");
        Image image2 = saveIcon.getImage();
        Image newimg2 = image2.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH);
        saveIcon = new ImageIcon(newimg2);

        //text filed for user input
        textField.setBounds(145,200,150,27);
        textField.setFont(new Font("MV Boli",Font.PLAIN,15));
        textField.setText("Add plate");

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

        //button:
        addPlateButton.setBounds(193,235,60,25);
        addPlateButton.addActionListener(this);
        addPlateButton.setText("Add");
        addPlateButton.setFont(new Font("MV Boli",Font.PLAIN,15));
        addPlateButton.setFocusable(false);
        addPlateButton.setBackground(new Color(0x071C4B));
        addPlateButton.setForeground(Color.white);
        addPlateButton.setBorder(BorderFactory.createEtchedBorder());

        //radio buttons: display, load and save
        display.setText("Display license plate(s)");
        display.setBounds(104,450,215,30);
        display.setBackground(new Color(0x123456));
        display.setForeground(Color.WHITE);
        display.setFont(new Font("MV Boli",Font.PLAIN,15));
        display.setFocusable(false);
        display.addActionListener(this);
        display.setIcon(displayIcon);
        load.setText(" Load license plates");
        load.setBounds(110,480,200,30);
        load.setBackground(new Color(0x123456));
        load.setForeground(Color.WHITE);
        load.setFont(new Font("MV Boli",Font.PLAIN,15));
        load.setFocusable(false);
        load.addActionListener(this);
        load.setIcon(loadIcon);
        save.setText(" Save license plates");
        save.setBounds(110,510,200,30);
        save.setBackground(new Color(0x123456));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("MV Boli",Font.PLAIN,15));
        save.setFocusable(false);
        save.addActionListener(this);
        save.setIcon(saveIcon);

        //radio button group
        buttonGroup.add(save);
        buttonGroup.add(load);
        buttonGroup.add(display);

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

        //adding to panel and frame
        panel.add(labelWelcomeHeader);
        panel.add(addPlateButton);
        panel.add(textField);
        panel.add(display);
        panel.add(save);
        panel.add(load);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPlateButton) {
            String plate = textField.getText().toUpperCase();
            licensePlateList = new LicensePlateList();
            licensePlateList.setPlate(plate);
            plates.addLp(licensePlateList);
        } else if (e.getSource() == display) {
            new ShowPlateGUI(plates);
        } else if (e.getSource() == load) {
            try {
                plates = jsonReader.read();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (e.getSource() == save) {
            try {
                jsonWriter.open();
                jsonWriter.write(plates);
                jsonWriter.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        }
    }
}
