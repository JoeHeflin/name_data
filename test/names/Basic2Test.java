package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Basic2Test {

    @Test
    void test1(){
        List<String> actual = Basic2.run("MaryLou","F",3002,3003);
        String[] actualArray = {"George, M","Margaret, F"};
        List<String> expected = new ArrayList<String>(Arrays.asList(actualArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

    @Test
    void multipleFromEachGender(){
        List<String> actual = Basic2.run("Ruth","F",3001,3003);
        String[] expectedArray = {"Charles, M","Robert, M","Joseph, M","MaryLou, F"};
        List<String> expected = new ArrayList<String>(Arrays.asList(expectedArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

    @Test
    void none(){
        List<String> actual = Basic2.run("Elijah","M",3001,3004);
        String[] actualArray = {};
        List<String> expected = new ArrayList<String>(Arrays.asList(actualArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

}