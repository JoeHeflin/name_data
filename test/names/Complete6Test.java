package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Complete6Test {
    @Test
    void notPresentAllYears() throws Exception {
        float avgRank = Complete6.mostRecentAvgRank("None","M",2);
        assertEquals(9, avgRank);
    }

    @Test
    void normalCase() throws Exception {
        float avgRank = Complete6.mostRecentAvgRank("Jonny","M",4);
        assertEquals(1.25,avgRank);
    }

    @Test
    void invalidYears(){
        assertThrows(Exception.class,()->{Complete6.mostRecentAvgRank("Elijah","M",15);});
    }
}