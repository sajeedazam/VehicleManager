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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.*;

//https://www.youtube.com/watch?v=Kmgo00avvEw&ab_channel=BroCode for gui knowledge
//https://www.youtube.com/watch?v=VMSTTg5EEnY&ab_channel=MrJavaHelp for music
//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon for image resize
public class Frame extends JFrame implements ActionListener {

    //fields
    protected AllPlates plates;
    private LicensePlateList licensePlateList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/LicensePlateManager.json";
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
        textField = new JTextField();
        buttonGroup = new ButtonGroup();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        licensePlateList = new LicensePlateList();
        plates = new AllPlates();

        //images: imported and resized
        ImageIcon logo = new ImageIcon("LicensePlateManagerAppLogo.png");
        this.setIconImage(logo.getImage());
        Border border = BorderFactory.createLineBorder(new Color(0x071C4B),4);

        //text filed for user input
        textField.setBounds(145,200,150,27);
        textField.setFont(new Font("MV Boli",Font.PLAIN,15));
        textField.setText("Add plate");

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

    private void dingSound() {
        AudioPlayer audioPlayer = AudioPlayer.player;
        AudioStream audioStream;
        AudioData audioData;
        AudioDataStream stream = null;
        try {
            audioStream = new AudioStream(new FileInputStream("DingSound.wav"));
            audioData = audioStream.getData();
            stream = new AudioDataStream(audioData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioPlayer.start(stream);
    }

    private void popSound() {
        AudioPlayer audioPlayer = AudioPlayer.player;
        AudioStream audioStream;
        AudioData audioData;
        AudioDataStream stream = null;
        try {
            audioStream = new AudioStream(new FileInputStream("PopSound.wav"));
            audioData = audioStream.getData();
            stream = new AudioDataStream(audioData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioPlayer.start(stream);
    }

    private void setWelcomeHeader() {
        ImageIcon platePic = new ImageIcon("AddLicensePlate.png");
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

    private void setAddPlateButton() {
        addPlateButton = new JButton();
        addPlateButton.setBounds(193,235,60,25);
        addPlateButton.addActionListener(this);
        addPlateButton.setText("Add");
        addPlateButton.setFont(new Font("MV Boli",Font.PLAIN,15));
        addPlateButton.setFocusable(false);
        addPlateButton.setBackground(new Color(0x071C4B));
        addPlateButton.setForeground(Color.white);
        addPlateButton.setBorder(BorderFactory.createEtchedBorder());
    }

    private void setDisplayButton() {
        display = new JRadioButton();
        ImageIcon displayIcon = new ImageIcon("DisplayButton.png");
        Image image0 = displayIcon.getImage();
        Image newImage0 = image0.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        displayIcon = new ImageIcon(newImage0);

        display.setText("Display license plate(s)");
        display.setBounds(104,450,215,30);
        display.setBackground(new Color(0x123456));
        display.setForeground(Color.WHITE);
        display.setFont(new Font("MV Boli",Font.PLAIN,15));
        display.setFocusable(false);
        display.addActionListener(this);
        display.setIcon(displayIcon);
        buttonGroup.add(display);
    }

    private void setLoadButton() {
        load = new JRadioButton();
        ImageIcon loadIcon = new ImageIcon("LoadButton.png");
        Image image1 = loadIcon.getImage();
        Image newImage1 = image1.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH);
        loadIcon = new ImageIcon(newImage1);

        load.setText(" Load license plates");
        load.setBounds(110,480,200,30);
        load.setBackground(new Color(0x123456));
        load.setForeground(Color.WHITE);
        load.setFont(new Font("MV Boli",Font.PLAIN,15));
        load.setFocusable(false);
        load.addActionListener(this);
        load.setIcon(loadIcon);
        buttonGroup.add(load);
    }

    private void setSaveButton() {
        save = new JRadioButton();
        ImageIcon saveIcon = new ImageIcon("SaveButton.png");
        Image image2 = saveIcon.getImage();
        Image newImage2 = image2.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH);
        saveIcon = new ImageIcon(newImage2);

        save.setText(" Save license plates");
        save.setBounds(110,510,200,30);
        save.setBackground(new Color(0x123456));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("MV Boli",Font.PLAIN,15));
        save.setFocusable(false);
        save.addActionListener(this);
        save.setIcon(saveIcon);
        buttonGroup.add(save);
    }

    private void addPlateAction(String plate) {
        licensePlateList.setPlate(plate);
        plates.addLp(licensePlateList);
        dingSound();
    }

    private void addToPanel(JPanel panel) {
        panel.add(labelWelcomeHeader);
        panel.add(addPlateButton);
        panel.add(textField);
        panel.add(display);
        panel.add(save);
        panel.add(load);
    }

    private void setPanel() {
        panel = new JPanel();
        Border border = BorderFactory.createLineBorder(new Color(0x071C4B),4);
        panel.setBackground(new Color(0x123456));
        panel.setBounds(0,0,1,1);
        panel.setLayout(null);
        panel.setBorder(border);
    }

    private void setInterface() {
        setWelcomeHeader();
        setAddPlateButton();
        setDisplayButton();
        setLoadButton();
        setSaveButton();
        setPanel();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPlateButton) {
            String plate = textField.getText().toUpperCase();
            addPlateAction(plate);
        } else if (e.getSource() == display) {
            new ShowPlateGUI(plates);
            popSound();
        } else if (e.getSource() == load) {
            try {
                plates = jsonReader.read();
                popSound();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (e.getSource() == save) {
            try {
                jsonWriter.open();
                jsonWriter.write(plates);
                jsonWriter.close();
                popSound();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}
