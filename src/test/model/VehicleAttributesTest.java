package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleAttributesTest {
    VehicleAttributes vehicle1,vehicle2;

    @BeforeEach
    public void setUp() {
        vehicle1 = new VehicleAttributes("Blue Bike",
                "Nissan","Working");
        vehicle2 = new VehicleAttributes("Red Truck",
                "Mercedes","Faulty");
    }

    @Test
    public void testVehicleUseDefaultWorks() {
        assertEquals(true,vehicle1.isVehicleIsPrivate());
    }
}