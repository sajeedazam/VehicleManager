package model;

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
