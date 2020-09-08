package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Basic1Test {

    @Test
    void nameNotPresentAll() throws Exception {
        List<Integer> actual = Basic1.ranksInDataset("None", "M");
        int[] expected = {9,10,9,9,8,1,9,9,9,9,9,9,9};

        int index = 0;
        for (int value:actual){
//            System.out.println(value);
            assertEquals(expected[index],value);
            index++;
        }
    }

    @Test
    void notPresentSome() throws Exception {
        List<Integer> actual = Basic1.ranksInDataset("Elijah", "M");
        int[] expected = {6,8,9,9,8,1,8,6,6,6,6,6,6};

        int index = 0;
        for (int value:actual){
            assertEquals(expected[index],value);
            index ++;
        }
    }

    @Test
    void presentAll() throws Exception {
        List<Integer> actual = Basic1.ranksInDataset("MaryLou", "F");
        int[] expected = {3,3,1,5,5,1,2,4,4,4,4,4,4};

        int index = 0;
        for (int value:actual){
            assertEquals(expected[index],value);
            index ++;
        }

    }
}