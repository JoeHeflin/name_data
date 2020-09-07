package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Basic2Test {
    void Basic2Test(){
        Main.setDataPath(Main.LOCAL_TEST_DATA);
    }

    @Test
    void singleNameFromEachGender() throws Exception {
        List<String> actual = Basic2.findNamesOfEqualRank("Ruth","F",3002);//,3003);
        String[] actualArray = {"Ruth, F", "William, M"};
        List<String> expected = new ArrayList<String>(Arrays.asList(actualArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

    @Test
    void multipleFromEachGender() throws Exception {
        List<String> actual = Basic2.findNamesOfEqualRank("Margaret","F",3001);//,3003);
        String[] expectedArray = {"Anna, F", "Helen, F", "Jonny, M"};
        List<String> expected = new ArrayList<String>(Arrays.asList(expectedArray));

        for(String value:expected){
            System.out.println(actual);
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

    @Test
    void none() throws Exception {
        List<String> actual = Basic2.findNamesOfEqualRank("Rafa","M",3001);//,3004);
        String[] actualArray = {};
        List<String> expected = new ArrayList<String>(Arrays.asList(actualArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

}