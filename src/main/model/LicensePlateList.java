package model;

import java.util.ArrayList;
import java.util.List;


public class LicensePlateList {
    //this class stores the License plates and also stores the corresponding
    //Vehicle Attributes associated to it by using ArrayList.

    //fields
    private String plate;
    private List<VehicleAttributes> vehicleAttributes;


    //EFFECTS:  constructs a LicensePlateList;
    public LicensePlateList() {
        vehicleAttributes = new ArrayList<>();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    //EFFECTS:  returns the VehicleAttributes from the ArrayList;
    public List<VehicleAttributes> getVehicleAttributes() {
        return vehicleAttributes;
    }

    public void setVehicleAttributes(List<VehicleAttributes> vehicleAttributes) {
        this.vehicleAttributes = vehicleAttributes;
    }

    public void addVehicleAttributes(VehicleAttributes vehicleAttribute) {
        vehicleAttributes.add(vehicleAttribute);
    }

    //    //EFFECTS:  returns the License Plate;
//    public String getLicensePlateList() {
//        return plate;
//    }
//
//    //EFFECTS:  adds VehicleAttributes to the ArrayList;

//



//    private void displayLicensePlates() {
//        List<VehicleAttributes> vehicleAttributes = getVehicleAttributes();
//
//    }
}
