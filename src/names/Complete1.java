package names;

import java.util.ArrayList;
import java.util.List;

public class Complete1 {

    /**
     * Finds the rankings of name/gender pair within range of years
     * @param givenName name in name/gender pair
     * @param gender in name/gander pair
     * @param years over which to look [first year, last year]
     * @return
     * @throws Exception
     */
    public static List<Integer> run(String givenName, String gender, int[] years) throws Exception {
        List<Integer> ranks = new ArrayList<Integer>();
        for (int year = years[0]; year < years[1]+1; year++) {
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
