package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AllPlatesTest {
    AllPlates allPlates;
    LicensePlateList licensePlateList;

    @BeforeEach
    public void setUp() {
        allPlates = new AllPlates();
        licensePlateList = new LicensePlateList();
    }

    @Test
    public void testAllPlatesWorks() {
        assertEquals(0,allPlates.getLp().size());
        allPlates.addLp(licensePlateList);
        assertEquals(1,allPlates.getLp().size());
    }

    @Test
    public void testSearchPlatesWorks() {
        assertNull(allPlates.searchPlate("123ABC",allPlates));
        licensePlateList.setPlate("123ABC");
        allPlates.addLp(licensePlateList);
        assertEquals(licensePlateList.getPlate(),allPlates.searchPlate("123ABC",allPlates).getPlate());

    }
}
