package names;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void p1q1() {
        /*
        Cases:
        1) 1900
        2) 1950
        3) 2000
         */
        String[] soln = {"Jonny","MaryLou"};
        String[] actual = Main.p1q1(1000);
        boolean ret = Arrays.equals(soln, actual);
        System.out.println("Expected: "+soln[0]+","+soln[1]+" Actual: "+actual[0]+","+actual[1]);
        //assertEquals(ret,false);
        assertTrue(ret);

    }

    @org.junit.jupiter.api.Test
    void p1q2() {
        /*
        Cases:
        1) 1899, F, M
        2) 2005, M, X
        3) 2005, M, D
         */
    }

    @Test
    void p2q1(){
        List<Integer> ranks = Main.p2q1("Elizabeth","F");
        System.out.println(ranks);
    }

    @Test
    void p2q2(){
        System.out.print(Main.p2q2("Adelle","F",1881));
    }
}