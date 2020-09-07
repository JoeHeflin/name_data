package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Complete6Test {
    @Test
    void notPresentSomeYears(){
        //int[] years = {3000,3004};
        assertThrows(Exception.class,()->{Complete6.run("George","M",2);});
    }

    @Test
    void normalCase() throws Exception {
        //int[] years = {3000,3004};
        float avgRank = Complete6.run("Jonny","M",4);
        assertEquals(1.25,avgRank);
    }

    @Test
    void invalidYears(){
        //int[] years = {3002,3000};
        assertThrows(Exception.class,()->{Complete6.run("Elijah","M",13);});
    }
}