package persistance;

import exception.PlateStringTooLongException;
import model.AllPlates;
import model.VehicleAttributes;
import model.LicensePlateList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//used keys for JsonObject (Task 2)
//citation: json implementations from JsonSerializationDemo;
public class JsonReader {

    //fields
    private String source;

    //EFFECTS:  constructs reader to read from source file;
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS:  reads AllPlates from file and returns it;
    //          throws IOException if an error occurs reading data from file;
    public AllPlates read() throws IOException, PlateStringTooLongException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAllPlates(jsonObject);
    }

    //EFFECTS:  reads source file as string and returns it;
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    //EFFECTS:  parses AllPlates from JSON object and returns it;
    private AllPlates parseAllPlates(JSONObject jsonObject) throws PlateStringTooLongException {
        AllPlates allPlates = new AllPlates();
        addToListOfPlates(allPlates, jsonObject);
        return allPlates;
    }

    //MODIFIES: allPlates;
    //EFFECTS:  parses licensePlateList from JSON object and adds them to AllPlates;
    private void addToListOfPlates(AllPlates allPlates, JSONObject jsonObject) throws PlateStringTooLongException {
        JSONArray jsonArray = jsonObject.getJSONArray("allPlates");
        for (Object json : jsonArray) {
            JSONObject nextPlate = (JSONObject) json;
            addPlate(allPlates, nextPlate);
        }
    }

    //MODIFIES: allPlates;
    //EFFECTS:  parses LicensePlateList from JSON object and adds it to AllPlates;
    private void addPlate(AllPlates allPlates, JSONObject jsonObject) throws PlateStringTooLongException {
        String plateNumber = jsonObject.getString("plates");
        LicensePlateList licensePlateList = new LicensePlateList();
        licensePlateList.setPlate(plateNumber);
        allPlates.addLp(licensePlateList);
        addVechicleAttributes(licensePlateList, jsonObject);
    }

    //MODIFIES: licensePlateList;
    //EFFECTS:  parses vehicleAttributes from JSON object and adds them to AllPlates;
    private void addVechicleAttributes(LicensePlateList licensePlateList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("vechAtts");
        for (Object json : jsonArray) {
            JSONObject nextVechAtt = (JSONObject) json;
            addVehicleAttribute(licensePlateList, nextVechAtt);
        }
    }

    //MODIFIES: licensePlateList;
    //EFFECTS:  parses VehicleAttributes froM JSON object and adds them to AllPlates;
    private void addVehicleAttribute(LicensePlateList licensePlateList, JSONObject jsonObject) {
        VehicleAttributes vehicleAttributes = new VehicleAttributes();
        String ctype = jsonObject.getString("ctype");
        vehicleAttributes.setVehicleColourAndType(ctype);
        String model = jsonObject.getString("model");
        vehicleAttributes.setVehicleModel(model);
        String comment = jsonObject.getString("comment");
        vehicleAttributes.setVehicleComment(comment);
        boolean use = jsonObject.getBoolean("use");
        vehicleAttributes.setVehicleIsPrivate(use);
        licensePlateList.addVehicleAttributes(vehicleAttributes);
    }
}
