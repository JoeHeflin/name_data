package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameArrayTest {

    @Test
    void findMaxYear() {
        NameArray n = new NameArray();
        int maxYear = n.findMaxYear();
        assertEquals(maxYear,2018);
    }

    @Test
    void findMinYear() {
        NameArray n = new NameArray();
        int minYear = n.findMinYear();
        assertEquals(minYear,1880);
    }
}