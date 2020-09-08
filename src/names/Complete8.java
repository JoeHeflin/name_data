package names;

import java.util.ArrayList;
import java.util.List;

public class Complete8 {
    private static int count;
    private static List<String> names;

    public static List<String> getNames() {
        return names;
    }

    public static int getCount() {
        return count;
    }

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
        count = f.getFrequency();
        names = new ArrayList<>(f.getNames());
        names.sort(String::compareTo);
    }
}
