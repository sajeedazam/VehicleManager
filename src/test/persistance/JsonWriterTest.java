package persistance;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import model.AllPlates;
import model.LicensePlateList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

//citation: from JsonSerializationDemo
public class JsonWriterTest extends JsonTest{

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
            LicensePlateList licensePlateList1 = new LicensePlateList();
            AllPlates allPlates = new AllPlates();
            LicensePlateList licensePlateList = new LicensePlateList();
            licensePlateList.setPlate("123ABC");
            licensePlateList1.setPlate("ABC123");
            allPlates.addLp(licensePlateList);
            allPlates.addLp(licensePlateList1);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAllPlates.json");

            writer.open();
            writer.write(allPlates);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAllPlates.json");
            allPlates = reader.read();

            List<LicensePlateList> licensePlateLists2 = allPlates.getLicensePlateList();
            assertEquals(2, allPlates.getLp().size());
            checkVehicleAtributes("Not set.","Not set.","Not set.",true,vehicleAttributes);
            checkAllPlates("123ABC", licensePlateLists2.get(0));
            checkAllPlates("ABC123",licensePlateLists2.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
