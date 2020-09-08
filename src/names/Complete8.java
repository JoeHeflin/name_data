package names;

import java.util.ArrayList;
import java.util.List;

public class Complete8 {
    public static int count;
    public static List<String> names;

    /**
     * Finds most common name at a given rank over a range of years
     * @param years [first year, last year]
     * @param gender
     * @param rank
     * @throws Exception
     */
    public static void mostCommonAtRank(int[] years, String gender, int rank) throws Exception {
        List<String> namesAtRank = Complete7.namesAtRank(years, gender, rank);
        Frequencies f = new Frequencies();
        f.maxNameAtRank(namesAtRank);
        count = f.frequency;
        names = new ArrayList<>(f.names);
        names.sort(String::compareTo);
    }
}
