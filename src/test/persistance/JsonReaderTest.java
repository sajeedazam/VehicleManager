package persistance;

import model.AllPlates;
import model.VehicleAttributes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

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
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            AllPlates allPlates = reader.read();
            assertEquals("My work room", allPlates.getLp());
            assertEquals(0, allPlates.getLp().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
