package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Complete1Test {

    @Test
    void nameNotPresentAll() throws Exception {
        int[] years = {3000,3003};
        List<Integer> actual = Complete1.ranksInRange("Joe", "M", years);
        int[] expected = {-1,-1,-1,-1};

        for (int value:actual){
            assertEquals(value,expected[actual.indexOf(value)]);
        }
    }

    @Test
    void notPresentSome() throws Exception {
        int[] years = {3000,3002};
        List<Integer> actual = Complete1.ranksInRange("Elijah", "M", years);
        int[] expected = {6,8,-1};

        for (int value:actual){
            assertEquals(expected[actual.indexOf(value)],value);
        }
    }

    @Test
    void presentAll() throws Exception {
        int[] years = {3000,3002};
        List<Integer> actual = Complete1.ranksInRange("Jonny", "M", years);
        int[] expected = {1,2,1};

        for (int value:actual){
            assertEquals(expected[actual.indexOf(value)],value);
        }

    }

}