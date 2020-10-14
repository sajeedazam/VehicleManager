package ui;

import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import java.util.List;
import java.util.Scanner;

//License Plate Manager Application
public class LicensePlateManager {

    //fields
    private AllPlates allPlates = new AllPlates();
    private LicensePlateList lp = new LicensePlateList();
    private final Scanner scan = new Scanner(System.in);

    //EFFECT: runs the LicensePlateManager application.
    public LicensePlateManager() {
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
    //          if user inputs add then it should call the addVehicleHelper() method;
    //          if user inputs show then it should call the displayLicensePlates() method;
    private void action(String userInput) {
        if (userInput.equals("add")) {
            addLicensePlateListName();
            System.out.println("Vehicle successfully added.");
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
        } else {
            System.out.println("Invalid input. Try something else.");
        }
    }

    //EFFECTS:  prints menu interface;
    private void activity() {
        System.out.println("User must enter the correct license plate everytime.");
        System.out.println("Make action:");
        System.out.println("-Enter Add to add a new license plate.");
        System.out.println("-Enter CType to add colour and type to your Vehicle. (Black Car/ White Truck)");
        System.out.println("-Enter Model to add brand name to your Vehicle.");
        System.out.println("-Enter Use to declare use of a Vehicle.");
        System.out.println("-Enter Comment to comment on a Vehicle.");
        System.out.println("-Enter Show to display all the license plates.");
        System.out.println("-Enter Attributes to display vehicle attributes.");
        System.out.println("-Enter Close to quit.");
    }

    //EFFECTS:  initializes a VehicleAttributes object using vehicleColourAndTypeInput,vehicleModelInput
    //          and vehicleCommentInput inputs from user;
    //          initializes LicensePlateList and uses insertLicensePlate;
    //          maps the VehiclesAttributes object inside the LicensePlateList by using addVehicleAttribute();
    //          prompts user to declare if the vehicle is of private or commercial use and sets it;
    private void addVechPrivateOrCom() {
        lp = getUserInputLicensePlate();

        VehicleAttributes vech = new VehicleAttributes();

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
    }

    //EFFECTS:  displays all the added license plates and it's information that is mapped to it;
    private void displayLpAtts() {
        lp = getUserInputLicensePlate();

        System.out.println(lp.getVehicleAttributes().toString());
    }

    //EFFECTS:  asks user which license plate and returns the license plate if it exists
    private LicensePlateList getUserInputLicensePlate() {
        System.out.println("Which License Plate?");
        String userLp = scan.nextLine();
        userLp = userLp.toUpperCase();
        for (LicensePlateList lp : allPlates.getLp()) {
            if (lp.getPlate().equals(userLp)) {
                return lp;
            }
        }
        return lp;
    }

    //
    private void addVechColourAndType() {
        lp = getUserInputLicensePlate();

        VehicleAttributes vech = new VehicleAttributes();
        System.out.println("Enter vehicle colour and type: (Black Bike/ White Car)");
        String addedColourAndType = scan.nextLine();

        vech.setVehicleColourAndType(addedColourAndType);
        lp.addVehicleAttributes(vech);
    }

    private void addVechModel() {
        lp = getUserInputLicensePlate();

        VehicleAttributes vech = new VehicleAttributes();

        System.out.println("Enter vehicle model: (Nissan / Toyota / Whatever applies)");
        String addedModel = scan.nextLine();

        vech.setVehicleModel(addedModel);
        lp.addVehicleAttributes(vech);
    }

    private void addVechComment() {
        lp = getUserInputLicensePlate();

        VehicleAttributes vech = new VehicleAttributes();

        System.out.println("Enter vehicle comment:");
        String addedComment = scan.nextLine();

        lp.addVehicleAttributes(vech);
      //  lp.setVehicleAttributes();
        vech.setVehicleComment(addedComment);

    }

    //EFFECTS:  prompts user to enter all the required vehicle attributes and it's license plate;
    //          calls the addLicensePlate() method with the user's inserted license plate;
    //          calls the addVehicleAttributes() method with all the necessary inputs from the user into
    //          it's parameters;
    private void addLicensePlateListName() {
        System.out.println("Enter the license plate: ");
        lp = new LicensePlateList();
        String addedLicensePlate = scan.nextLine();
        addedLicensePlate = addedLicensePlate.toUpperCase();
        lp.setPlate(addedLicensePlate);
        allPlates.addLp(lp);
    }

    //EFFECTS:  prints out all the license plates;
    private void showAllLicensePlates()  {
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
