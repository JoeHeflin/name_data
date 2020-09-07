package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Complete5Test {

    @Test
    void moreThanOneName() throws Exception {
        int[] years = {3008,3010};
        List<String> actual = Complete5.run(years,"M");
        List<String> expected = new ArrayList<>(Arrays.asList("Charles","James","Jonny"));
        for(String name:actual){
//            System.out.println(name);
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

    @Test
    void normalCase() throws Exception {
        int[] years = {3008,3011};
        List<String> actual = Complete5.run(years,"M");
        List<String> expected = new ArrayList<>(Arrays.asList("James"));
        for(String name:actual){
//                        System.out.println(name);
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

    @Test
    void lastYearInRangeChangesAnswer() throws Exception {
        int[] years = {3008,3012};
        List<String> actual = Complete5.run(years,"M");
        List<String> expected = new ArrayList<>(Arrays.asList("Jonny"));
        for(String name:actual){
                                    System.out.println(name);
            assertEquals(0,name.compareTo(expected.get(actual.indexOf(name))));
        }
    }

}