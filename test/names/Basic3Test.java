package names;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Basic3Test {

    @Test
    void male() throws Exception {
        int[] years = {3000,3004};

        Frequencies ans = Basic3.findMostTopRanks(years,"M");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals("George".compareTo(s.pop()),0);
        assertEquals(3,f);

    }

    @Test
    void female() throws Exception {
        int[] years = {3000,3004};

        Frequencies ans = Basic3.findMostTopRanks(years,"F");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals("Margaret".compareTo(s.pop()),0);
        assertEquals(4,f);
    }

    @Test
    void tieMale() throws Exception {
        int[] years = {3000,3003};

        Frequencies ans = Basic3.findMostTopRanks(years,"M");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals(0, "George".compareTo(s.pop()));
        assertEquals(0, "Jonny".compareTo(s.pop()));
        assertEquals(2,f);
    }

}