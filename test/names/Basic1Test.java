package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Basic1Test {

    @Test
    void nameNotPresentAll() throws Exception {
        //int[] years = {3000,3003};
        List<Integer> actual = Basic1.run("None", "M");
        int[] expected = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

        int index = 0;
        for (int value:actual){
            assertEquals(expected[index],value);
            index++;
        }
    }

    @Test
    void notPresentSome() throws Exception {
        //int[] years = {3000,3002};
        List<Integer> actual = Basic1.run("Elijah", "M");
        int[] expected = {6,8,-1,-1,-1,-1,8,6,6,6,6,6,6};

        int index = 0;
        for (int value:actual){
            assertEquals(expected[index],value);
            index ++;
        }
    }

    @Test
    void presentAll() throws Exception {
        //int[] years = {3000,3003};
        List<Integer> actual = Basic1.run("MaryLou", "F");
        int[] expected = {3,3,1,5,5,1,2,4,4,4,4,4,4};

        int index = 0;
        for (int value:actual){
            assertEquals(expected[index],value);
            index ++;
        }

    }
}