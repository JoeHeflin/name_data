package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Complete2Test {

    @Test
    void sameRank() throws Exception {
        int[] years = {3000,3002};
        int diff = Complete2.rankDiff("M","Jonny",years);
        assertEquals(0,diff);
    }

    @Test
    void nameFoundOneYearButNotOther() throws Exception {
        int[] years = {3000,3004};
        int diff = Complete2.rankDiff("M","Elijah",years);
        assertEquals(-2,diff);
    }

    @Test
    void normal() throws Exception{
        int[] years = {3000,3004};
        int diff = Complete2.rankDiff("M","Jonny",years);
        assertEquals(-1,diff);
    }
}