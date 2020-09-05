package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameArrayTest {

    @Test
    void arrayGen() throws Exception {
        int[] years = {1900,1903};
        NameArray.setDataPath(Main.REMOTE_TEST_DATA);
        NameArray n = new NameArray("M",years);
        n.rankGenerator();
        for(Name name:n.nameArray){
           // System.out.println(name.name);
        }
    }

    @Test
    void findMaxYear() throws Exception {
        NameArray.setDataPath(Main.LOCAL_TEST_DATA);

        NameArray n = new NameArray(3000);
        int maxYear = n.findMaxYear();
        assertEquals(3005, maxYear);
    }

    @Test
    void findMinYear() throws Exception {
        NameArray.setDataPath(Main.LOCAL_TEST_DATA);
        NameArray n = new NameArray(3000);
        int minYear = n.findMinYear();
        assertEquals(minYear,3000);
    }

    @Test
    void rankGenerator() throws Exception {
        NameArray.setDataPath(Main.LOCAL_TEST_DATA);
        NameArray n = new NameArray(3000);
        n.rankGenerator();

        }
    }
