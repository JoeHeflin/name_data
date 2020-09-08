package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameArrayTest {

    @Test
    void arrayGen() throws Exception {
        int[] years = {1900,1903};
        Main.setDataPath(Main.REMOTE_TEST_DATA);
        NameArray n = new NameArray("M",years);
        n.rankGenerator();
        for(Name name:n.getNameArray()){
           // System.out.println(name.name);
        }
    }

    @Test
    void findMaxYear() throws Exception {
        Main.setDataPath(Main.LOCAL_TEST_DATA);

        NameArray n = new NameArray(3000);
        int maxYear = Main.findMaxYear();
        assertEquals(3012, maxYear);
    }

    @Test
    void findMinYear() throws Exception {
        Main.setDataPath(Main.LOCAL_TEST_DATA);
        NameArray n = new NameArray(3000);
        int minYear = Main.findMinYear();
        assertEquals(minYear,3000);
    }

    @Test
    void rankGenerator() throws Exception {
        Main.setDataPath(Main.LOCAL_TEST_DATA);
        NameArray n = new NameArray(3000);
        n.rankGenerator();

    }

    @Test
    void invalidDataSet() throws Exception {
        Main.setDataPath("src/names/");
        assertThrows(Exception.class, ()->{Main.findMaxYear();});
    }

    }
