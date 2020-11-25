package model;

import exception.PlateStringTooLongException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistance.Writable;

import java.util.ArrayList;
import java.util.List;

//citation: json implementations from JsonSerializationDemo
//this class stores the License plates and also stores the corresponding
//Vehicle Attributes associated to it by using ArrayList.
public class LicensePlateList implements Writable {

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

    //MODIFIES: this
    //EFFECTS:  sets plate and throws PlateStringTooLongException if the plate string is longer than 7;
    public void setPlate(String plate) throws PlateStringTooLongException {
        if (plate.length() > 7) {
            throw new PlateStringTooLongException("Plate name too long");
        } else {
            this.plate = plate;
        }
    }

    //EFFECTS:  returns the VehicleAttributes from the ArrayList;
    public List<VehicleAttributes> getVehicleAttributes() {
        return vehicleAttributes;
    }

    //MODIFIES: vehicleAttributes;
    //EFFECTS:  adds vehicle attributes;
    public void addVehicleAttributes(VehicleAttributes vehicleAttribute) {
        vehicleAttributes.add(vehicleAttribute);
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("plates", plate);
        json.put("vechAtts", vehicleAttributesToJson());
        return json;
    }

    //EFFECTS:  returns vehicleAttributes as a json array;
    private JSONArray vehicleAttributesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (VehicleAttributes vech : vehicleAttributes) {
            jsonArray.put(vech.toJson());
        }
        return jsonArray;
    }

}
