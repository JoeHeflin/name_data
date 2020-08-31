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
    void test2(){
        List<String> actual = Basic2.run("MaryLou","F",3002,3003);//TODO
        String[] actualArray = {"George, M","Margaret, F"};//TODO
        List<String> expected = new ArrayList<String>(Arrays.asList(actualArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

    @Test
    void test3(){
        List<String> actual = Basic2.run("MaryLou","F",3002,3003);//TODO
        String[] actualArray = {"George, M","Margaret, F"};//TODO
        List<String> expected = new ArrayList<String>(Arrays.asList(actualArray));

        for(String value:expected){
            assertEquals(value.compareTo(actual.get(expected.indexOf(value))),0);
        }
    }

}