package model;

import java.util.ArrayList;
import java.util.List;

public class LicensePlateList {

    String plate;
    List<VehicleAttributes> vehicleAttributes = new ArrayList<>();

    public LicensePlateList(String plate) {
        this.plate = plate;
    }

    public String getLicensePlateList() {
        return plate;
    }

    public void addVehicleAttributes(VehicleAttributes vehicleAttribute) {
        vehicleAttributes.add(vehicleAttribute);
    }

    public List<VehicleAttributes> getVehicleAttributes() {
        return vehicleAttributes;
    }

}
