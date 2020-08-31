package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test2Test {

    @Test
    void singleFemale(){
        int[] actual = Test2.run(3000,"F","A");
        int[] expected = {1,6};

        for(int i = 0; i < 2;i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void multipleMales(){
        int[] actual = Test2.run(3000,"M", "J");
        int[] expected = {3,2600};

        for(int i = 0; i < 2;i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void letterNotPresent(){
        int[] actual = Test2.run(3000,"M", "A");
        int[] expected = {0,0};

        for(int i = 0; i < 2;i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

}