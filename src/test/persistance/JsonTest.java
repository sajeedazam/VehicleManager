package persistance;

import model.LicensePlateList;
import model.VehicleAttributes;
import model.AllPlates;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    VehicleAttributes vehicleAttributes = new VehicleAttributes();
    AllPlates allPlates = new AllPlates();

    protected void checkVehicleAtributes(String ctype, String model,String comment,Boolean use) {
        assertEquals(ctype,vehicleAttributes.getVehicleColourAndType());
        assertEquals(model,vehicleAttributes.getVehicleModel());
        assertEquals(comment,vehicleAttributes.getVehicleComment());
        assertEquals(use,vehicleAttributes.isVehicleIsPrivate());
    }

    protected void checkAllPlates(LicensePlateList licensePlateList, String plates) {
        assertEquals(plates,licensePlateList.getPlate());
    }
}
