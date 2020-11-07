package model;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import persistance.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//citation: json implementations from JsonSerializationDemo
//this class stores all the license plates being made as an arraylist
public class AllPlates implements Writable {

    //fields
    List<LicensePlateList> lp;

    //EFFECTS:  constructs AllPlates;
    public AllPlates() {
        lp = new ArrayList<>();
    }

    //EFFECTS: returns the license plate;
    public List<LicensePlateList> getLp() {
        return lp;
    }

    //EFFECTS: adds a license plate into the array;
    public void addLp(LicensePlateList lp0) {
        lp.add(lp0);
    }

    //EFFECTS: searches for the license plate and returns it;
    public LicensePlateList searchPlate(String userLp,AllPlates allPlates) {
        for (LicensePlateList lp : allPlates.getLp()) {
            if (lp.getPlate().equals(userLp)) {
                return lp;
            }
        }
        return null;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("allPlates", allPlatesToJson());
        return json;
    }

    //EFFECTS:  return allPlates as json array;
    private JSONArray allPlatesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (LicensePlateList plate : lp) {
            jsonArray.put(plate.toJson());
        }
        return jsonArray;
    }

    public List<LicensePlateList> getLicensePlateList() {
        return Collections.unmodifiableList(lp);
    }

}
