package names;

import java.util.List;
import java.util.Stack;

public class Basic4 {

    /**
     * Gives all names beginning with the most common letter given the parameters
     * @param years over which to look [first year,last year]
     * @param gender for which to look "M" or "F"
     * @return a stack containing names in alphabetical order
     * @throws Exception
     */
    public static Stack<String> findNamesWithMostCommonLetter(int[] years,String gender) throws Exception {
        NameArray data = new NameArray(gender,years);
        Frequencies f = new Frequencies();
        f.maxLetterFreq(data.nameArray);
        Stack<String> s = f.names;
        s.sort(String::compareTo);
        return s;
    }
}
