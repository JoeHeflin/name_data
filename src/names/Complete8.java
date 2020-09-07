package names;

import java.util.ArrayList;
import java.util.List;

public class Complete8 {
    public static int count;
    public static List<String> names;

    public static void run(int[] years, String gender, int rank) throws Exception {
        List<String> namesAtRank = Complete7.run(years, gender, rank);
        Frequencies f = new Frequencies();
        f.maxNameAtRank(namesAtRank);
        count = f.frequency;
        names = new ArrayList<>(f.names);
        names.sort(String::compareTo);
    }
}
