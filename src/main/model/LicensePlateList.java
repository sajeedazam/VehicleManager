package model;

import java.util.ArrayList;
import java.util.List;

//this class stores the License plates and also stores the corresponding
//Vehicle Attributes associated to it by using ArrayList.
public class LicensePlateList {

    //fields
    private String plate;
    private List<VehicleAttributes> vehicleAttributes;


    //EFFECTS:  constructs a LicensePlateList;
    public LicensePlateList() {
        vehicleAttributes = new ArrayList<>();
    }

    //EFFECTS: returns plate;
    public String getPlate() {
        return plate;
    }

    //EFFECTS:  sets plate;
    public void setPlate(String plate) {
        this.plate = plate;
    }

    //EFFECTS:  returns the VehicleAttributes from the ArrayList;
    public List<VehicleAttributes> getVehicleAttributes() {
        return vehicleAttributes;
    }

    //EFFECTS:  adds vehicle attributes;
    public void addVehicleAttributes(VehicleAttributes vehicleAttribute) {
        vehicleAttributes.add(vehicleAttribute);
    }


}
