package ui;

import exception.PlateStringTooLongException;
import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import persistance.JsonReader;
import persistance.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//JSON citation: JsonSerializationDemo
//License Plate Manager Application
public class LicensePlateManager {

    //fields
    private AllPlates allPlates = new AllPlates();
    private LicensePlateList lp = new LicensePlateList();
    private final Scanner scan = new Scanner(System.in);
    private static final String JSON_STORE = "./data/LicensePlateManager.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECT: runs the LicensePlateManager application.
    public LicensePlateManager() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runLicensePlateManager();
    }

    //EFFECTS: Processes user input
    private void runLicensePlateManager() {
        boolean runApp = true;
        String userInput;
        do {
            activity();
            userInput = scan.nextLine();
            userInput = userInput.toLowerCase();

            if (userInput.equals("close")) {
                runApp = false;
            } else {
                action(userInput);
            }

        } while (runApp);

        System.out.println("LicensePlateManager closed.");
    }

    //MODIFIES: this
    //EFFECTS:  decides what to do with the user input;
    //          if user inputs add then it should call the addLicensePlateListName() method;
    //          if user inputs ctype then it should call the addVechColourAndType() method;
    //          if user inputs model then it should call the addVechModel() method;
    //          if user inputs use then it should call the addVechPrivateOrCom() method;
    //          if user inputs comment then it should call the addVechComment() method;
    //          if user inputs show then it should call the displayLicensePlates() method;
    //          if user inputs attributes then it should call the displayLpAtts() method;
    //          if user inputs save then it should call the savePlates() method;
    //          if user inputs load then it should call the loadPlates() method;
    //          if user inputs anything else then it should print a string indicating its a wrong input;
    private void action(String userInput) {
        if (userInput.equals("add")) {
            addLicensePlateListName();
        } else if (userInput.equals("ctype")) {
            addVechColourAndType();
        } else if (userInput.equals("model")) {
            addVechModel();
        } else if (userInput.equals("use")) {
            addVechPrivateOrCom();
        } else if (userInput.equals("comment")) {
            addVechComment();
        } else if (userInput.equals("show")) {
            showAllLicensePlates();
        } else if (userInput.equals("attributes")) {
            displayLpAtts();
        } else if (userInput.equals("save")) {
            savePlates();
        } else if (userInput.equals("load")) {
            loadPlates();
        } else {
            System.out.println("Invalid input. Try something else.");
        }
    }

    //EFFECTS:  loads plates from the file;
    private void loadPlates() {
        try {
            try {
                allPlates = jsonReader.read();
            } catch (PlateStringTooLongException e) {
                e.printStackTrace();
            }
            System.out.println("Loaded");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS:  saves plates to the file;
    private void savePlates() {
        try {
            jsonWriter.open();
            jsonWriter.write(allPlates);
            jsonWriter.close();
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //EFFECTS:  prints menu interface;
    private void activity() {
        System.out.println("**User is limited to adding one unique detail per license plate.");
        System.out.println("Make action:");
        System.out.println("\t-Enter Add to add a new license plate.");
        System.out.println("\t-Enter CType to add colour and type to your Vehicle. (Black Car/ White Truck)");
        System.out.println("\t-Enter Model to add brand name to your Vehicle.");
        System.out.println("\t-Enter Use to declare use of a Vehicle.");
        System.out.println("\t-Enter Comment to comment on a Vehicle.");
        System.out.println("\t-Enter Show to display all the license plates.");
        System.out.println("\t-Enter Attributes to display vehicle attributes.");
        System.out.println("\t-Enter Save to save work to file.");
        System.out.println("\t-Enter Load to load work from file.");
        System.out.println("\t-Enter Close to quit.");
    }

    //MODIFIES: lp
    //EFFECTS:  initializes a VehicleAttributes object using vehicleColourAndTypeInput,vehicleModelInput
    //          and vehicleCommentInput inputs from user;
    //          initializes LicensePlateList and uses insertLicensePlate;
    //          maps the VehiclesAttributes object inside the LicensePlateList by using addVehicleAttribute();
    //          prompts user to declare if the vehicle is of private or commercial use and sets it;
    private void addVechPrivateOrCom() {
        lp = getUserInputLicensePlate();
        VehicleAttributes vech = new VehicleAttributes();

        if (lp == null) {
            System.out.println("License Plate does not exist.");
        } else {
            String answer = "";
            while (!(answer.equals("private") || answer.equals("commercial"))) {
                System.out.println("Enter Private if vehicle is for private use, commercial otherwise.");
                answer = scan.nextLine();
                answer = answer.toLowerCase();
            }
            if (answer.equals("private")) {
                vech.setVehicleIsPrivate(true);
            } else {
                vech.setVehicleIsPrivate(false);
            }
            lp.addVehicleAttributes(vech);
        }
    }

    //MODIFIES: lp
    //EFFECTS:  displays all the added license plates and it's information that is mapped to it;
    private void displayLpAtts() {
        lp = getUserInputLicensePlate();
        if (lp == null) {
            System.out.println("License Plate does not exist.");
        } else {
            System.out.println(lp.getVehicleAttributes().toString());
        }
    }

    //EFFECTS:  asks user which license plate and returns the license plate if it exists;
    private LicensePlateList getUserInputLicensePlate() {
        System.out.println("Which License Plate?");
        String userLp = scan.nextLine();
        userLp = userLp.toUpperCase();
        return allPlates.searchPlate(userLp,allPlates);  //updated code: removed from ui and added to model
    }

    //MODIFIES: lp
    //EFFECTS:  calls getUserInputLicensePlate();
    //          initiates a vehicle and sets it's colour and type;
    private void addVechColourAndType() {
        lp = getUserInputLicensePlate();
        VehicleAttributes vech = new VehicleAttributes();

        if (lp == null) {
            System.out.println("License Plate does not exist.");
        } else {
            System.out.println("Enter vehicle colour and type: (Black Bike/ White Car)");
            String addedColourAndType = scan.nextLine();
            vech.setVehicleColourAndType(addedColourAndType);
            lp.addVehicleAttributes(vech);
        }
    }

    //MODIFIES: lp
    //EFFECTS:  calls getUserInputPlate();
    //          initiates a vehicle and sets it's model;
    private void addVechModel() {
        lp = getUserInputLicensePlate();
        VehicleAttributes vech = new VehicleAttributes();

        if (lp == null) {
            System.out.println("License Plate does not exist.");
        } else {
            System.out.println("Enter vehicle model: (Nissan / Toyota / Whatever applies)");
            String addedModel = scan.nextLine();
            vech.setVehicleModel(addedModel);
            lp.addVehicleAttributes(vech);
        }
    }

    //MODIFIES: lp
    //EFFECTS:  calls getUserInputPlate();
    //          initiates a vehicle and sets it's comment;
    private void addVechComment() {
        lp = getUserInputLicensePlate();
        VehicleAttributes vech = new VehicleAttributes();

        if (lp == null) {
            System.out.println("License Plate does not exist.");
        } else {
            System.out.println("Enter vehicle comment:");
            String addedComment = scan.nextLine();
            lp.addVehicleAttributes(vech);
            vech.setVehicleComment(addedComment);
        }
    }

    //MODIFIES: lp
    //EFFECTS:  prompts user to enter all the required vehicle attributes and it's license plate;
    //          calls the addLicensePlate() method with the user's inserted license plate;
    //          calls the addVehicleAttributes() method with all the necessary inputs from the user into
    //          it's parameters;
    private void addLicensePlateListName() {
        System.out.println("Enter the license plate: ");
        lp = new LicensePlateList();
        String addedLicensePlate = scan.nextLine();
        addedLicensePlate = addedLicensePlate.toUpperCase();
        try {
            lp.setPlate(addedLicensePlate);
            allPlates.addLp(lp);
            System.out.println("Vehicle successfully added.");
        } catch (PlateStringTooLongException e) {
            System.out.println("Plate is too long");
        }

    }

    //EFFECTS:  prints out all the license plates;
    //          catches exception if theres a null array;
    private void showAllLicensePlates() {
        System.out.println("All the license plates are as follows:");
        try {
            List<LicensePlateList> allLp = allPlates.getLp();
            for (LicensePlateList lp : allLp) {
                System.out.println(lp.getPlate());
            }
        } catch (NullPointerException e) {
            System.out.println("No License plates added.");
        }
    }

}
