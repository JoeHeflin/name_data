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
    void findMinYear() throws Exception {
        NameArray n = new NameArray();
        int minYear = n.findMinYear();
        assertEquals(minYear,1880);
    }

    @Test
    void rankGenerator() {
        NameArray n = new NameArray(3000);
        n.rankGenerator();

        }
    }
