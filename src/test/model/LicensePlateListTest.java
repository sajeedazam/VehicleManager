package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LicensePlateListTest {

    LicensePlateList plate1, plate2;
    VehicleAttributes attributes1, attributes2;

    @BeforeEach
    public void setUp() {
        plate1 = new LicensePlateList("123ABC");
        attributes1 = new VehicleAttributes("Black Car",
                "Nissan","No comments.");
    }

    @Test
    public void testGetLicensePlateWorks() {
        assertEquals("123ABC",plate1.getLicensePlateList());

    }

    @Test
    public void testGetVehicleAttributesWorks() {
        plate1.addVehicleAttributes(attributes1);
        assertEquals("[Vehicle Attributes { Colour and Type ='Black Car', Model ='Nissan'" +
                        " Comment ='No comments.', Is vehicle private? = Vehicle is of Private use.}]"
                ,plate1.getVehicleAttributes().toString());
    }
}
