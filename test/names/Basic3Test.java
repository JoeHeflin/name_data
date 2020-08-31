package names;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Basic3Test {

    @Test
    void test1(){
        int[] years = {3000,3004};

        Frequencies ans = Basic3.run(years,"M");
        Stack<String> s = ans.names;
        int f = ans.frequency;

        assertEquals("George".compareTo(s.pop()),0);
        assertEquals(3,f);

    }

}