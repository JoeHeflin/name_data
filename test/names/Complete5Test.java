package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Complete5Test {

    @Test
    void moreThanOneName(){
        int[] years = {3100,3112};
        List<String> actual = Complete5.run(years,"M");
    }

    @Test
    void normalCase(){
        int[] years = {3100,3113};
        List<String> actual = Complete5.run(years,"M");
    }

    @Test
    void lastYearInRangeChangesAnswer(){
        int[] years = {3100,3113};
        List<String> actual = Complete5.run(years,"M");
    }

}