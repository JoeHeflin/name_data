package names;

import java.util.ArrayList;
import java.util.List;

public class Basic1 {

    /**
     * Gives the ranks of a name/gander pair for every year in dataset
     * @param name to find ranks of
     * @param gender to find ranks of
     * @return a chronological list of the ranks
     * @throws Exception
     */
    public static List<Integer> ranksInDataset(String name, String gender) throws Exception {
        int[] years = {Main.findMinYear(),Main.findMaxYear()};
        List<Integer> rank = Complete1.ranksInRange(name,gender,years);
        return rank;
    }
}