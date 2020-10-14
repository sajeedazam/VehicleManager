package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAllPlates {
    AllPlates allPlates;
    LicensePlateList licensePlateList;

    @BeforeEach
    public void setUp() {
        allPlates = new AllPlates();
        licensePlateList = new LicensePlateList();
    }

    @Test
    public void testAllPlatesWork() {
        assertEquals(0,allPlates.getLp().size());
        allPlates.addLp(licensePlateList);
        assertEquals(1,allPlates.getLp().size());

    }
}
