package model;

import java.util.Arrays;

//Represents a License Plate having License Plate number, type of vehicle, model of vehicle,
//colour of vehicle, declare commercial or private, add comment/complaint
public class LicensePlate {

    //fields
    public static int nextLicensePlateId = 1;  // tracks how many license plates are created
    private static int id;                      // license plate id
    private String licensePlate;                // license plate of the vehicle
    private String vehicleType;                 // type of the vehicle
    private String vehicleModel;                // model of vehicle
    private String vehicleColour;               // colour of vehicle
    private String vehicleComment;              // comment on vehicle
    private boolean vehicleIsPrivate;           // whether commercial or private use (true = private use)

    //constructor

    /*MODIFIES: this
     *EFFECTS:  the license plate name is set to licensePlate;
     *          license plate id is a positive integer not assigned to other license plates;
     *          vehicleType is initialized as "Not set." by default";
     *          vehicleModel is initialized as "Not set." by default;
     *          vehicleColour is initialized as "Not set." by default;
     *          vehicleComment is initialized as "No comments made." by default;
     *          vehicleUse is initialized as "true" by default;
     */
    public LicensePlate(String licensePlateUserInput) {
        id = nextLicensePlateId++;
        licensePlate = licensePlateUserInput;
        this.setVehicleType("Not set.");
        this.setVehicleModel("Not set.");
        this.setVehicleColour("Not set.");
        this.setVehicleComment("No comments made.");
        this.setVehicleIsPrivate(true);
    }

    //methods

    //IGNORE BELOW METHOD
    /*REQUIRES: licensePlate[].equals(checker);
     *EFFECTS:  this method is a helper method for the constructor that checks if the
     *          input of the user already exists in the licensePlate Array so that there are
     *          no duplications of the same license plate.
     */
//    public boolean checkPlateExists(String checker) {
//
//        for (String i : licensePlate) {
//            if (licensePlate[Integer.parseInt(i)].equals(checker)) {
//                continue;
//            }
//            return true;
//        }
//
//        return false;
//    }
    //IGNORE ABOVE METHOD


    //getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public String getVehicleComment() {
        return vehicleComment;
    }

    public boolean isVehicleIsPrivate() {
        return vehicleIsPrivate;
    }

    //setters
//    public static void setLicensePlate(String[] licensePlate) {
//        LicensePlate.licensePlate = licensePlate;
//    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public void setVehicleComment(String vehicleComment) {
        this.vehicleComment = vehicleComment;
    }

    public void setVehicleIsPrivate(boolean vehicleIsPrivate) {
        this.vehicleIsPrivate = vehicleIsPrivate;
    }

    //toString


    public String toString() {
        return "LicensePlate{" + "licensePlate='" + licensePlate + '\'' + ", vehicleType='"
                + vehicleType + '\'' + ", vehicleModel='" + vehicleModel + '\'' + ", vehicleColour='"
                + vehicleColour + '\'' + ", vehicleComment='" + vehicleComment + '\''
                + ", vehicleIsPrivate=" + vehicleIsPrivate + '}';
    }
}
