package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LicensePlateListTest {

    LicensePlateList plate1;
    VehicleAttributes attributes1;

    @BeforeEach
    public void setUp() {
        plate1 = new LicensePlateList();
        attributes1 = new VehicleAttributes();
    }

    @Test
    public void testGetPlateWorks() {
        assertEquals(null,plate1.getPlate());
        plate1.setPlate("123-ABC");
        assertEquals("123-ABC",plate1.getPlate());
    }

    @Test
    public void testGetVehicleAttributesWorks() {
        plate1.addVehicleAttributes(attributes1);
        assertEquals("[Vehicle Attributes { Colour and Type ='Not set.', Model ='Not set.'" +
                        " Comment ='Not set.', Is vehicle private? = Vehicle is of Private use.}]"
                ,plate1.getVehicleAttributes().toString());
    }
}
