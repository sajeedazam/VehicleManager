package persistance;

import model.AllPlates;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

}
