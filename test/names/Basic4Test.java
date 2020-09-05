package names;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Basic4Test {

    @Test
    void test1() throws Exception {
        int[] years = {3000,3004};
        NameArray n = new NameArray("F",years);
        Stack<String> s = n.maxLetterFreq();
        s.sort(String::compareTo);

        assertEquals(0, "MaryLou".compareTo(s.pop()));
        assertEquals(0, "Margaret".compareTo(s.pop()));

    }

    @Test
    void tieLetter() throws Exception {

        int[] years = {3002,3002};
        NameArray n = new NameArray("M",years);
        Stack<String> s = n.maxLetterFreq();
        s.sort(String::compareTo);

        //System.out.println(s.pop());
        assertEquals(0, "Joseph".compareTo(s.pop()));
        assertEquals(0, "Jonny".compareTo(s.pop()));
    }

    @Test
    void highFreqLowCount() throws Exception {
        int[] years = {3000,3005};
        NameArray n = new NameArray("F",years);
        Stack<String> s = n.maxLetterFreq();
        s.sort(String::compareTo);

        assertEquals(0, "MaryLou".compareTo(s.pop()));
        assertEquals(0, "Margaret".compareTo(s.pop()));
    }

}