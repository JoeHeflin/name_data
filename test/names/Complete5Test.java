package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Complete5Test {

    @Test
    void moreThanOneName(){
        int[] years = {3100,3112};
        List<String> actual = Complete5.run(years,"M");
        List<String> expected = new ArrayList<>(Arrays.asList("Charles","James","Jonny"));
        for(String name:actual){
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

    @Test
    void normalCase(){
        int[] years = {3100,3113};
        List<String> actual = Complete5.run(years,"M");
        List<String> expected = new ArrayList<>(Arrays.asList("James"));
        for(String name:actual){
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

    @Test
    void lastYearInRangeChangesAnswer(){
        int[] years = {3100,3114};
        List<String> actual = Complete5.run(years,"M");
        List<String> expected = new ArrayList<>(Arrays.asList("Jonny"));
        for(String name:actual){
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

}