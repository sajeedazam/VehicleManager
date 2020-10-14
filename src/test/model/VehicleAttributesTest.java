package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleAttributesTest {
    VehicleAttributes vehicle1;

    @BeforeEach
    public void setUp() {
        vehicle1 = new VehicleAttributes();
    }

    @Test
    public void testVehicleUseDefaultWorks() {
        assertEquals(true,vehicle1.isVehicleIsPrivate());
        assertEquals("Not set.",vehicle1.getVehicleColourAndType());
        assertEquals("Not set.",vehicle1.getVehicleComment());
        assertEquals("Not set.",vehicle1.getVehicleModel());
        assertEquals("Vehicle is of Private use.",vehicle1.getVehiclePrivateOrNot());
    }

    @Test
    public void testGetVehiclePrivateOrNotWorks() {
        assertEquals("Vehicle is of Private use.",vehicle1.getVehiclePrivateOrNot());
        vehicle1.setVehicleIsPrivate(false);
        assertEquals("Vehicle is of Commercial use.",vehicle1.getVehiclePrivateOrNot());
    }

    @Test
    public void testToStringWorks() {
        assertEquals("Vehicle Attributes { Colour and Type ='Not set.'," +
                " Model ='Not set.' Comment ='Not set.', Is vehicle private? = Vehicle is of Private use.}"
                ,vehicle1.toString());
    }
}