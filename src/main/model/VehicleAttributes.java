package model;

import java.util.Arrays;

//Represents a License Plate having License Plate number, type of vehicle, model of vehicle,
//colour of vehicle, declare commercial or private, add comment/complaint
public class VehicleAttributes {

    //fields
    private String vehicleColourAndType;        // colour and type of the vehicle (i.e black sedan, white truck,etc)
    private String vehicleModel;                // model of vehicle
    private String vehicleComment;              // comment on vehicle
    private boolean vehicleIsPrivate;           // whether commercial or private use (true = private use)

    //constructor

    /*MODIFIES: this
     *EFFECTS:  license plate id is a positive integer not assigned to other license plates;
     *          vehicleColourAndType is initialized as vehicleColourAndTypeInput;
     *          vehicleModel is initialized as vehicleModelInput;
     *          vehicleComment is initialized as vehicleComment;
     *          vehicleUse is initialized as "true" by default;
     */
    public VehicleAttributes(String vehicleColourAndTypeInput, String vehicleModelInput, String vehicleComment) {
        this.setVehicleColourAndType(vehicleColourAndTypeInput);
        this.setVehicleModel(vehicleModelInput);
        this.setVehicleComment(vehicleComment);
        this.setVehicleIsPrivate(true);
    }

    //methods
    //getters

    public String getVehicleColourAndType() {
        return vehicleColourAndType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleComment() {
        return vehicleComment;
    }

    public String getVehiclePrivateOrNot() {
        if (this.isVehicleIsPrivate() == false) {
            return "Vehicle is of Commercial use.";
        } else {
            return "Vehicle is of Private use.";
        }
    }

    public boolean isVehicleIsPrivate() {
        return vehicleIsPrivate;
    }

    //setters

    public void setVehicleColourAndType(String vehicleType) {
        this.vehicleColourAndType = vehicleType;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }


    public void setVehicleComment(String vehicleComment) {
        this.vehicleComment = vehicleComment;
    }

    public void setVehicleIsPrivate(boolean vehicleIsPrivate) {
        this.vehicleIsPrivate = vehicleIsPrivate;
    }


    @Override
    public String toString() {
        return "Vehicle Attributes { Colour and Type ='"
                + this.getVehicleColourAndType() + '\'' + ", Model ='" + this.getVehicleModel()
                + '\'' + " Comment ='" + this.getVehicleComment() + '\'' + ", Is vehicle private? = "
                + this.getVehiclePrivateOrNot() + '}';
    }

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
}
