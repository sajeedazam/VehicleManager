package ui;

import model.LicensePlateList;
import model.VehicleAttributes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//License Plate Manager Application
public class LicensePlateManager {

    //fields
    HashMap<String, LicensePlateList> licensePlatesLists = new LinkedHashMap<>();
    private final Scanner scan = new Scanner(System.in);

    //EFFECT: runs the LicensePlateManager application.
    public LicensePlateManager() {
        runLicensePlateManager();
    }

    private void runLicensePlateManager() {
        boolean runApp = true;
        String userInput;
        do {
            activity();
            userInput = scan.next();
            userInput = userInput.toLowerCase();

            if (userInput.equals("close")) {
                runApp = false;
            } else {
                action(userInput);
            }

        } while (runApp);

        System.out.println("LicensePlateManager closed.");
    }

    private void action(String userInput) {
        if (userInput.equals("add")) {
            addVehicleAttributesHelper();
            System.out.println("Vehicle successfully added.");
        }
        if (userInput.equals("show")) {
            displayLicensePlates();
        }
    }

    private void activity() {
        System.out.println("Make action:");
        System.out.println("-Enter Add to add a new license plate.");
        System.out.println("-Enter Show to see license plates.");
        System.out.println("-Enter Close to quit.");
    }

    private void addLicensePlate(String insertLicensePlate) {
        LicensePlateList plates = new LicensePlateList(insertLicensePlate);
        licensePlatesLists.put(insertLicensePlate,plates);
    }

    private void addVehicleAttributes(String insertLicensePlate, String vehicleColourAndTypeInput,
                                      String vehicleModelInput, String vehicleCommentInput) {
        VehicleAttributes newVehicle
                = new VehicleAttributes(vehicleColourAndTypeInput,vehicleModelInput,vehicleCommentInput);
        LicensePlateList plates = new LicensePlateList(insertLicensePlate);
        plates.addVehicleAttributes(newVehicle);

        String answer = "";
        while (!(answer.equals("private") || answer.equals("commercial"))) {
            System.out.println("Enter Private if vehicle is for private use, commercial otherwise.");
            answer = scan.next();
            answer = answer.toLowerCase();
        }

        if (answer.equals("private")) {
            newVehicle.setVehicleIsPrivate(true);
        } else {
            newVehicle.setVehicleIsPrivate(false);
        }
    }

    private void displayLicensePlates() {

        for (Map.Entry<String, LicensePlateList> entry : licensePlatesLists.entrySet()) {
            LicensePlateList plates = entry.getValue();
            System.out.println("License Plate: " + plates.getLicensePlateList());
            System.out.println(plates.getVehicleAttributes());
        }

    }

    private void addVehicleAttributesHelper() {
        System.out.println("Enter the license plate: ");
        String addedLicensePlate = scan.next();

        System.out.println("Enter vehicle colour: ");
        String addedColour = scan.next();

        System.out.println("Enter vehicle Type: (Bike / Sedan / Truck)");
        String addedType = scan.next();

        System.out.println("Enter vehicle model: (Nissan / Toyota / Whatever applies)");
        String addedVehicleModel = scan.next();

        System.out.println("Enter vehicle comment:");
        String addedVehicleComment = scan.next();

        String addedVehicleColourAndType = addedColour + " " + addedType;

        addedLicensePlate = addedLicensePlate.toUpperCase();
        addLicensePlate(addedLicensePlate);
        addVehicleAttributes(addedLicensePlate,addedVehicleColourAndType,
                addedVehicleModel,addedVehicleComment);


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
