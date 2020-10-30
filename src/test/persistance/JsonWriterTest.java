package persistance;

import model.AllPlates;
import model.LicensePlateList;
import model.VehicleAttributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{
//    AllPlates allPlates;
//    LicensePlateList licensePlateList;
//    VehicleAttributes vehicleAttributes;
//
//    @BeforeEach
//    public void setUp() {
//        allPlates = new AllPlates();
//        licensePlateList = new LicensePlateList();
//        vehicleAttributes = new VehicleAttributes();
//    }

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
            AllPlates allPlates = new AllPlates();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyAllPlates.json");
            writer.open();
            writer.write(allPlates);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyAllPlates.json");
            allPlates = reader.read();
            assertEquals(0, allPlates.getLp().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralAllPlates() {
        try {
            AllPlates allPlates = new AllPlates();
            LicensePlateList licensePlateList = new LicensePlateList();
            licensePlateList.setPlate("123ABC");
            allPlates.addLp(licensePlateList);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAllPlates.json");
            writer.open();
            writer.write(allPlates);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAllPlates.json");
            allPlates = reader.read();
            assertEquals(1, allPlates.getLp().size());
            checkVehicleAtributes("Not set.","Not set.","Not set.",true);
            checkAllPlates(licensePlateList,"123ABC");
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
