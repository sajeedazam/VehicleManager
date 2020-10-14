package model;

import java.util.ArrayList;
import java.util.List;

public class AllPlates {
    List<LicensePlateList> lp;

    public AllPlates() {
        lp = new ArrayList<>();
    }

    public List<LicensePlateList> getLp() {
        return lp;
    }

    public void setLp(List<LicensePlateList> lp) {
        this.lp = lp;
    }

    public void addLp(LicensePlateList lp0) {
        lp.add(lp0);
    }
}
