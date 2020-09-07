package names;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Complete8Test {

        @Test
        void singleName() throws Exception {
                int[] years = {3000,3004};
                Complete8 c = new Complete8();
                Complete8.run(years,"F",5);
                List<String> actualNames = c.names;
                List<String> expectedNames = new ArrayList<>(Arrays.asList("Ruth"));//,"Ruth","Ruth","MaryLou","MaryLou"));
                for(String year:actualNames){
                        assertEquals(0,year.compareTo(expectedNames.get(actualNames.indexOf(year))));
                }
                assertEquals(3,c.count);
        }

        @Test
        void multipleNames() throws Exception {
                int[] years = {3000,3002};
                Complete8 c = new Complete8();
                Complete8.run(years,"F",1);
                List<String> actualNames = c.names;
                List<String> expectedNames = new ArrayList<>(Arrays.asList("Helen","Margaret"));
                for(String year:actualNames){
                        assertEquals(0,year.compareTo(expectedNames.get(actualNames.indexOf(year))));
                }
                assertEquals(2,c.count);
        }

        @Test
        void invalidRank(){
                int[] years = {3000,3004};
                assertThrows(Exception.class, ()->{Complete8.run(years,"F",13);});
        }
}