package persistance;

import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//citation: from JsonSerializationDemo
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            AllPlates allPlates = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyAllPlates() {
        try {
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyAllPlates.json");
            writer.open();
            writer.write(allPlates);
            writer.close();
            JsonReader reader = new JsonReader("./data/testReaderEmptyAllPlates.json");
            AllPlates allPlates = reader.read();
            assertEquals(0, allPlates.getLp().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testModelClasses() {
        try {
            vehicleAttributes.setVehicleModel("model");
            vehicleAttributes.setVehicleIsPrivate(true);
            vehicleAttributes.setVehicleColourAndType("ctype");
            vehicleAttributes.setVehicleComment("comment");
            licensePlateList.setPlate("123ABC");
            allPlates.addLp(licensePlateList);
            licensePlateList.addVehicleAttributes(vehicleAttributes);
            checkVehicleAtributes("ctype","model","comment",true,vehicleAttributes);

            JsonWriter writer = new JsonWriter("./data/testReaderEmptyAllPlates.json");
            writer.open();
            writer.write(allPlates);
            writer.close();
            JsonReader reader = new JsonReader("./data/testReaderEmptyAllPlates.json");

            AllPlates allPlates = reader.read();
            List<LicensePlateList> licensePlateLists1 = allPlates.getLicensePlateList();
            assertEquals(1,licensePlateLists1.size());
            assertEquals(1, allPlates.getLp().size());
            checkAllPlates("123ABC", licensePlateLists1.get(0));
            checkVehicleAtributes("ctype","model","comment",true,vehicleAttributes);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
