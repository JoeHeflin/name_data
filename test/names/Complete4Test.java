package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Complete4Test {

    @Test
    void notPresentSomeYears() throws Exception{
        int[] years = {3000,3004};
        float avgRank = Complete4.avgRank("Elijah","M",years);
        assertEquals(8, Math.round(avgRank));
    }

    @Test
    void normalCase() throws Exception {
        int[] years = {3000,3004};
        float avgRank = Complete4.avgRank("George","M",years);
        assertEquals(3,avgRank);
    }

    @Test
    void invalidYears(){
        int[] years = {3002,3000};
        assertThrows(Exception.class,()->{Complete4.avgRank("Elijah","M",years);});
    }

}