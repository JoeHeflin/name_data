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
//        List<Integer> ranks = new ArrayList<>();
//        for (int year = Main.findMinYear() ; year < Main.findMaxYear() + 1 ; year++) {
//            NameArray n = new NameArray(gender, year);
//            try {
//                ranks.add(n.findRank(name));
//            } catch (Exception e) {
//                ranks.add(-1);
//            }
//        }
//        return ranks;
        int[] years = {Main.findMinYear(),Main.findMaxYear()};
        List<Integer> rank = Complete1.run(name,gender,years);
        return rank;
    }
}