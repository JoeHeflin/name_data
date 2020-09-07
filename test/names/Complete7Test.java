package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Complete7Test {

    @Test
    void singleName() throws Exception {
        int[] years = {3000,3004};
        List<String> actualNames = Complete7.run(years,"F",5);
        List<String> expectedNames = new ArrayList<>(Arrays.asList("Ruth","Ruth","Ruth","MaryLou","MaryLou"));
        for(String year:actualNames){
                assertEquals(0,year.compareTo(expectedNames.get(actualNames.indexOf(year))));
        }
    }

    @Test
    void multipleNames() throws Exception {
        int[] years = {3000,3004};
        List<String> actualNames = Complete7.run(years,"F",1);
        List<String> expectedNames = new ArrayList<>(Arrays.asList(
                "Helen, Margaret","Margaret","Anna, Helen, MaryLou","Margaret","Margaret"));
        for(String year:actualNames){
            assertEquals(0,year.compareTo(expectedNames.get(actualNames.indexOf(year))));
        }
    }

    @Test
    void invalidRank(){
        int[] years = {3000,3004};
        assertThrows(Exception.class, ()->{Complete7.run(years,"F",13);});
    }

}