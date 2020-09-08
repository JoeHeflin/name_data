package names;

import java.util.ArrayList;
import java.util.List;

public class Complete3 {

    /**
     * Finds names who's rank changed the most from the first year to
     * last year of given range
     * @param years [first year, last year]
     * @param gender gender over which to search
     * @return list of names who's rank changed the most
     * @throws Exception
     */
    public static List<String> maxRankDiff(int[] years, String gender) throws Exception {
        int maxRankDiffValue = 0;
        List<String> maxRankDiffNames = new ArrayList<>();

        NameArray oldYearData = new NameArray(gender, years[0]);
        NameArray newYearData = new NameArray(gender, years[1]);

        oldYearData.rankGenerator();
        newYearData.rankGenerator();

        for (Name name : oldYearData.nameArray) {
            int rankDiff = Math.abs(name.rank - newYearData.findRank(name.name));
            if (rankDiff == maxRankDiffValue) {
                maxRankDiffNames.add(name.name);
            } else if (rankDiff > maxRankDiffValue) {
                maxRankDiffNames.clear();
                maxRankDiffNames.add(name.name);
                maxRankDiffValue = rankDiff;
            }
        }
        maxRankDiffNames.sort(String::compareTo);
        return maxRankDiffNames;
    }
}
