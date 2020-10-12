package ui;

import model.LicensePlate;

import java.util.Scanner;

//License Plate Manager Application
public class LicensePlateManager {
    //fields
    LicensePlate made;
    private static int additions = 0;
    private Scanner in;

    //EFFECT: runs the LicensePlateManager application.
    private LicensePlateManager() {
        runLicensePlateManager();
    }

    private void runLicensePlateManager() {
        boolean runApp = true;
        String userInput;
        do {
            activity();
            userInput = in.next();
            userInput = userInput.toLowerCase();

            if (userInput.equals("close")) {
                runApp = false;
            } else {
                action(userInput);
            }

        } while (runApp = true);

        System.out.println("LicensePlateManager closed.");
    }

    private void action(String userInput) {
        if (userInput.equals("add")) {
            System.out.print("Enter the license plate: ");
            String addedLicensePlate = in.nextLine();
            addedLicensePlate = addedLicensePlate.toUpperCase();
            made = new LicensePlate(addedLicensePlate);

        }
        if (userInput.equals("show") {
            made.toString();
        }
    }

    private void activity() {
        System.out.println("Make action:");
        System.out.println("Enter Add to add a new license plate.");
        System.out.println("Enter Show to see license plates.");
        System.out.println("Enter Close to quit.");
    }

    ;

}
