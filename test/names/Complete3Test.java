package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Complete3Test {

    @Test
    void singleAnswer() throws Exception {
        int[] years = {3001,3006};
        List<String> actual = Complete3.maxRankDiff(years, "F");
        List<String> expected = new ArrayList<String>(Arrays.asList("Margaret"));
        for(String name:actual){
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

    @Test
    void multipleAnswers() throws Exception {
        int[] years = {3000, 3007};
        List<String> actual = Complete3.maxRankDiff(years, "F");
        List<String> expected = new ArrayList<String>(Arrays.asList("Anna", "Margaret", "MaryLou"));
        for (String name : actual) {
            assertEquals(0, name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

    @Test
    void nameDisappears(){
        int[] years = {3000, 3004};
        assertThrows(Exception.class,()->{List<String> actual = Complete3.maxRankDiff(years, "M");});
    }
}