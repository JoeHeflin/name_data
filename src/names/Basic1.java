package names;

import java.util.ArrayList;
import java.util.List;

public class Basic1 {
    public static List<Integer> run(String givenName, String gender) throws Exception {
        List<Integer> ranks = new ArrayList<>();
        for (int year = Main.findMinYear() ; year < Main.findMaxYear() + 1 ; year++) {
            NameArray n = new NameArray(gender, year);
            try {
                ranks.add(n.findRank(givenName));
            } catch (Exception e) {
                ranks.add(-1);
            }
        }
        return ranks;
    }
}