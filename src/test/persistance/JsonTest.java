package persistance;

import model.LicensePlateList;
import model.VehicleAttributes;
import model.AllPlates;
import static org.junit.jupiter.api.Assertions.assertEquals;

//citation: from JsonSerializationDemo
public class JsonTest {
    VehicleAttributes vehicleAttributes = new VehicleAttributes();
    AllPlates allPlates = new AllPlates();
    LicensePlateList licensePlateList = new LicensePlateList();
    protected void checkVehicleAtributes(String ctype, String model,String comment,Boolean use,
                                         VehicleAttributes vehicleAttributes) {
        assertEquals(ctype,vehicleAttributes.getVehicleColourAndType());
        assertEquals(model,vehicleAttributes.getVehicleModel());
        assertEquals(comment,vehicleAttributes.getVehicleComment());
        assertEquals(use,vehicleAttributes.isVehicleIsPrivate());
    }

    protected void checkAllPlates(String plates, LicensePlateList licensePlateList) {
        assertEquals(plates,licensePlateList.getPlate());
    }

    protected void checkVehicleAtributes(LicensePlateList licensePlateList, String ctype,
                                         String model,String comment,Boolean use) {
        assertEquals("Vehicle Attributes { Colour and Type ='"+vehicleAttributes.getVehicleColourAndType()
                        +"'," +
                        " Model ='"+vehicleAttributes.getVehicleModel()+"' Comment ='Not set.', Is vehicle private? " +
                        "= Vehicle is of Private use.}"
                ,vehicleAttributes.toString());

    }
}
