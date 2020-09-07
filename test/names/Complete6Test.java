package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Complete6Test {
    @Test
    void notPresentSomeYears(){
        assertThrows(Exception.class,()->{Complete6.run("None","M",2);});
    }

    @Test
    void normalCase() throws Exception {
        float avgRank = Complete6.run("Jonny","M",4);
        assertEquals(1.25,avgRank);
    }

    @Test
    void invalidYears(){
        assertThrows(Exception.class,()->{Complete6.run("Elijah","M",13);});
    }
}