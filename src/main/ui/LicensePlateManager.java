package ui;

import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import java.util.Scanner;

//License Plate Manager Application
public class LicensePlateManager {

    //fields
    private AllPlates allPlates;
    private VehicleAttributes vech;
    private LicensePlateList lp;
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
            addVehicleAttributesHelper();
            System.out.println("Vehicle successfully added.");
        }
        if (userInput.equals("show")) {
            this.displayLicensePlates();
        }
    }

    //EFFECTS:  prints menu interface;
    private void activity() {
        System.out.println("Make action:");
        System.out.println("-Enter Add to add a new license plate.");
        System.out.println("-Enter Show to see license plates.");
        System.out.println("-Enter Close to quit.");
    }

    //EFFECTS:  initializes a new LicensePlateList object using the insertLicensePlate input from user;
//    private void addLicensePlate(String insertLicensePlate) {
//        LicensePlateList plates = new LicensePlateList(insertLicensePlate);
//        licensePlatesLists.put(insertLicensePlate,plates);
//    }

    //EFFECTS:  initializes a VehicleAttributes object using vehicleColourAndTypeInput,vehicleModelInput
    //          and vehicleCommentInput inputs from user;
    //          initializes LicensePlateList and uses insertLicensePlate;
    //          maps the VehiclesAttributes object inside the LicensePlateList by using addVehicleAttribute();
    //          prompts user to declare if the vehicle is of private or commercial use and sets it;
    private void addVechPrivateOrCom() {

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
    private void displayLicensePlates() {


    }

    //EFFECTS:  prompts user to enter all the required vehicle attributes and it's license plate;
    //          calls the addLicensePlate() method with the user's inserted license plate;
    //          calls the addVehicleAttributes() method with all the necessary inputs from the user into
    //          it's parameters;
    private void addVehicleAttributesHelper() {
        System.out.println("Enter the license plate: ");
        licensePlateListName();


        addVechColourAndType();

        addVechModel();

        addVechComment();

        addVechPrivateOrCom();


    }

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


    private void addVechColourAndType() {
        lp = getUserInputLicensePlate();
        System.out.println("Enter vehicle colour and type: (Black Bike/ White Car)");
        String addedColourAndType = scan.nextLine();
        vech.setVehicleColourAndType(addedColourAndType);
        lp.addVehicleAttributes(vech);
    }

    private void addVechModel() {
        lp = getUserInputLicensePlate();
        System.out.println("Enter vehicle model: (Nissan / Toyota / Whatever applies)");
        String addedModel = scan.nextLine();
        vech.setVehicleModel(addedModel);
        lp.addVehicleAttributes(vech);
    }

    private void addVechComment() {
        lp = getUserInputLicensePlate();
        System.out.println("Enter vehicle comment:");
        String addedComment = scan.nextLine();
        vech.setVehicleComment(addedComment);
        lp.addVehicleAttributes(vech);
    }

    private void licensePlateListName() {
        lp = new LicensePlateList();
        String addedLicensePlate = scan.nextLine();
        addedLicensePlate = addedLicensePlate.toUpperCase();
        lp.setPlate(addedLicensePlate);
        allPlates.addLp(lp);
    }


    //IGNORE BELOW METHODS
//    private void returnMenu() {
//        String answer1 = "";
//        while (!(answer1.equals("return"))) {
//            System.out.print("Enter Return to return to menu.");
//            answer1 = scan.nextLine();
//            answer1 = answer1.toLowerCase();
//        }
//
//        if (answer1.equals("return")) {
//            activity();
//        }
//    }
//    private void initializeComment() {
//        String answer = "";
//       // VehicleAttributes test = new VehicleAttributes();
//        while (!(answer.equals("yes") || answer.equals("no"))) {
//            System.out.print("Do you want to add a comment? (Yes/No)");
//            answer = in.nextLine();
//            answer = answer.toLowerCase();
//        }
//
//        if (answer.equals("yes")) {
//            System.out.println("Enter your comment");
//            //test.setVehicleComment("ds");
//        }
//
//        if (answer.equals("no")) {
//            //stub
//        }
//    }
    //IGNORE ABOVE METHODS
}
