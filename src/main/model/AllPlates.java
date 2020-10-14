package model;

import java.util.ArrayList;
import java.util.List;

//this class stores all the license plates being made as an arraylist
public class AllPlates {

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

}
