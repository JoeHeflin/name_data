package names;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Basic3Test {

    @Test
    void male(){
        int[] years = {3000,3004};

        Frequencies ans = Basic3.run(years,"M");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals("George".compareTo(s.pop()),0);
        assertEquals(3,f);

    }

    @Test
    void female(){
        int[] years = {3000,3004};

        Frequencies ans = Basic3.run(years,"F");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals("Margaret".compareTo(s.pop()),0);
        assertEquals(4,f);
    }

    @Test
    void tieMale(){
        int[] years = {3000,3003};

        Frequencies ans = Basic3.run(years,"M");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals(0, "George".compareTo(s.pop()));
        assertEquals(0, "Jonny".compareTo(s.pop()));
        assertEquals(2,f);
    }

}