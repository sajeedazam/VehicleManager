package ui;

import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import persistance.JsonReader;
import persistance.JsonWriter;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.*;

//this class is used to create and run the gui
//https://www.youtube.com/watch?v=Kmgo00avvEw&ab_channel=BroCode for gui knowledge
//https://www.youtube.com/watch?v=VMSTTg5EEnY&ab_channel=MrJavaHelp for music
//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon for image resize
public class Swing extends JFrame implements ActionListener {

    //fields
    private AllPlates plates = new AllPlates();
    private LicensePlateList licensePlateList;
    private VehicleAttributes vehicleAttributes;
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;
    private static final String JSON_STORE = "./data/LicensePlateManagerGUI.json";
    JLabel labelWelcomeHeader;
    JPanel panel;
    JButton addPlateButton;
    JTextField textField;
    JTextField textField2;
    JRadioButton display;
    JRadioButton load;
    JRadioButton save;
    ButtonGroup buttonGroup;

    //MODIFIES: textField, this
    //EFFECTS:  constructs the GUI
    Swing() {
        //initializations
        textField = new JTextField();
        textField2 = new JTextField();
        buttonGroup = new ButtonGroup();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

        //logo
        ImageIcon logo = new ImageIcon("./data/LicensePlateManagerAppLogo.png");
        this.setIconImage(logo.getImage());

        //text filed for user input
        textField.setBounds(145,170,150,27);
        textField.setFont(new Font("MV Boli",Font.PLAIN,15));
        textField.setText("Add plate");
        textField2.setBounds(145,200,150,27);
        textField2.setFont(new Font("MV Boli",Font.PLAIN,15));
        textField2.setText("Add brand");

        //declaring and modifying all the components
        setInterface();

        //color of the background, title of the application and overall gui design. no method calls;
        this.setTitle("License Plate Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450,600);
        this.setVisible(true);

        //adding to panel and frame
        addToPanel(panel);
        this.add(panel);
    }

    //MODIFIES: audioStream
    //EFFECTS:  plays the DingSound.wav audio
    private void dingSound() {
        AudioPlayer audioPlayer = AudioPlayer.player;
        AudioStream audioStream;
        AudioData audioData;
        AudioDataStream stream = null;
        try {
            audioStream = new AudioStream(new FileInputStream("./data/DingSound.wav"));
            audioData = audioStream.getData();
            stream = new AudioDataStream(audioData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioPlayer.start(stream);
    }

    //MODIFIES: audioStream
    //EFFECTS:  plays the PopSound.wav audio
    private void popSound() {
        AudioPlayer audioPlayer = AudioPlayer.player;
        AudioStream audioStream;
        AudioData audioData;
        AudioDataStream stream = null;
        try {
            audioStream = new AudioStream(new FileInputStream("./data/PopSound.wav"));
            audioData = audioStream.getData();
            stream = new AudioDataStream(audioData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioPlayer.start(stream);
    }

    //MODIFIES: image, labelWelcomeHeader, this
    //EFFECTS:  creates the top header of the app, adds logo and adds it to the panel
    private void setWelcomeHeader() {
        ImageIcon platePic = new ImageIcon("./data/AddLicensePlate.png");
        Image image = platePic.getImage();
        Image newImage = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        platePic = new ImageIcon(newImage);

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
    }

    //MODIFIES: addPlateButton
    //EFFECTS:  creates the add button
    private void setAddPlateButton() {
        addPlateButton = new JButton();
        addPlateButton.setBounds(193,235,60,25);
        addPlateButton.addActionListener(e -> addPlateAction());
        addPlateButton.setText("add");
        addPlateButton.setFont(new Font("MV Boli",Font.PLAIN,13));
        addPlateButton.setFocusable(false);
        addPlateButton.setBackground(new Color(0x071C4B));
        addPlateButton.setForeground(Color.white);
        addPlateButton.setBorder(BorderFactory.createEtchedBorder());
    }

    //MODIFIES: display, image0, buttonGroup
    //EFFECTS:  creates display JRadioButton and adds an icon to it
    private void setDisplayButton() {
        display = new JRadioButton();
        ImageIcon displayIcon = new ImageIcon("./data/DisplayButton.png");
        Image image0 = displayIcon.getImage();
        Image newImage0 = image0.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        displayIcon = new ImageIcon(newImage0);

        display.setText("Display license plate(s)");
        display.setBounds(104,450,215,30);
        display.setBackground(new Color(0x123456));
        display.setForeground(Color.WHITE);
        display.setFont(new Font("MV Boli",Font.PLAIN,15));
        display.setFocusable(false);
        display.addActionListener(e -> addDisplayAction());
        display.setIcon(displayIcon);
        buttonGroup.add(display);
    }

    //MODIFIES: load, image1, buttonGroup
    //EFFECTS:  creates load JRadioButton and adds an icon to it
    private void setLoadButton() {
        load = new JRadioButton();
        ImageIcon loadIcon = new ImageIcon("./data/LoadButton.png");
        Image image1 = loadIcon.getImage();
        Image newImage1 = image1.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH);
        loadIcon = new ImageIcon(newImage1);

        load.setText(" Load license plates");
        load.setBounds(110,480,200,30);
        load.setBackground(new Color(0x123456));
        load.setForeground(Color.WHITE);
        load.setFont(new Font("MV Boli",Font.PLAIN,15));
        load.setFocusable(false);
        load.addActionListener(e -> addLoadAction());
        load.setIcon(loadIcon);
        buttonGroup.add(load);
    }

    //MODIFIES: save, image2, buttonGroup
    //EFFECTS:  creates save JRadioButton and adds an icon to it
    private void setSaveButton() {
        save = new JRadioButton();
        ImageIcon saveIcon = new ImageIcon("./data/SaveButton.png");
        Image image2 = saveIcon.getImage();
        Image newImage2 = image2.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH);
        saveIcon = new ImageIcon(newImage2);

        save.setText(" Save license plates");
        save.setBounds(110,510,200,30);
        save.setBackground(new Color(0x123456));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("MV Boli",Font.PLAIN,15));
        save.setFocusable(false);
        save.addActionListener(e -> addSaveAction());
        save.setIcon(saveIcon);
        buttonGroup.add(save);
    }

    //MODIFIES: licensePlateList, plates
    //EFFECTS:  performs the required action listener for the add button
    private void addPlateAction() {
        String plate = textField.getText().toUpperCase();
        String brand = textField2.getText();
        licensePlateList = new LicensePlateList();
        licensePlateList.setPlate(plate);
        vehicleAttributes = new VehicleAttributes();
        vehicleAttributes.setVehicleModel(brand);
        licensePlateList.addVehicleAttributes(vehicleAttributes);
        plates.addLp(licensePlateList);
        dingSound();
    }

    //MODIFIES: panel
    //EFFECTS:  adds whatever needed to the panel
    private void addToPanel(JPanel panel) {
        panel.add(labelWelcomeHeader);
        panel.add(addPlateButton);
        panel.add(textField);
        panel.add(textField2);
        panel.add(display);
        panel.add(save);
        panel.add(load);
    }

    //MODIFIES: panel
    //EFFECTS:  creates the panel
    private void setPanel() {
        panel = new JPanel();
        Border border = BorderFactory.createLineBorder(new Color(0x071C4B),4);
        panel.setBackground(new Color(0x123456));
        panel.setBounds(0,0,1,1);
        panel.setLayout(null);
        panel.setBorder(border);
    }

    //EFFECTS:  calls all the methods that makes up the GUI
    private void setInterface() {
        setWelcomeHeader();
        setAddPlateButton();
        setDisplayButton();
        setLoadButton();
        setSaveButton();
        setPanel();
    }

    //EFFECTS:  performs the required action listener for the display radiobutton
    private void addDisplayAction() {
        new ShowPlateGUI(plates);
        popSound();
    }

    //EFFECTS:  performs the required action listener for the load radiobutton
    private void addLoadAction() {
        try {
            plates = jsonReader.read();

            popSound();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    //MODIFIES: jsonWriter
    //EFFECTS:  performs the required action listener for the save radiobutton
    private void addSaveAction() {
        try {
            jsonWriter.open();
            jsonWriter.write(plates);
            jsonWriter.close();
            popSound();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Swing();
    }
}
