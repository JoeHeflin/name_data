package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Basic1Test {

    @Test
    void nameNotPresentAll(){
        int[] years = {3000,3003};
        List<Integer> actual = Basic1.run("Joe", "M", years);
        int[] expected = {-1,-1,-1,-1};

        for (int value:actual){
            assertEquals(value,expected[actual.indexOf(value)]);
        }
    }

    @Test
    void notPresentSome(){
        int[] years = {3000,3002};
        List<Integer> actual = Basic1.run("Elijah", "M", years);
        int[] expected = {6,8,-1};

        for (int value:actual){
            assertEquals(expected[actual.indexOf(value)],value);
        }
    }

    @Test
    void presentAll(){
        int[] years = {3000,3003};
        List<Integer> actual = Basic1.run("MaryLou", "F", years);
        int[] expected = {3,3,1,5};

        for (int value:actual){
            assertEquals(value,expected[actual.indexOf(value)]);
        }
    }
}