package persistance;

import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    AllPlates allPlates;
    LicensePlateList licensePlateList;
    VehicleAttributes vehicleAttributes;

    @BeforeEach
    public void setUp() {
        allPlates = new AllPlates();
        licensePlateList = new LicensePlateList();
        vehicleAttributes = new VehicleAttributes();
    }

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyAllPlates() {
        try {
            allPlates.addLp(licensePlateList);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(allPlates);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            allPlates = reader.read();
            assertEquals(licensePlateList, allPlates.getLp());
            assertEquals(0, allPlates.getLp().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralAllPlates() {
        try {
            licensePlateList.setPlate("123ABC");
            vehicleAttributes.setVehicleColourAndType("Black sedan");
            vehicleAttributes.setVehicleIsPrivate(true);
            vehicleAttributes.setVehicleComment("Commented");
            vehicleAttributes.setVehicleModel("Nissan");
            licensePlateList.addVehicleAttributes(vehicleAttributes);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(allPlates);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            allPlates = reader.read();
//          assertEquals("My work room", allPlates.getLp());
 //         List<Thingy> thingies = wr.getThingies();
            assertEquals(1, allPlates.getLp().size());
//            checkThingy("saw", Category.METALWORK, thingies.get(0));
//            checkThingy("needle", Category.STITCHING, thingies.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
