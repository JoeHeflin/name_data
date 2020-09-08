package names;

import javax.naming.NameNotFoundException;
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

        for (Name name : oldYearData.getNameArray()) {
            int rankDiff;
            try {
                rankDiff = Math.abs(name.getRank() - newYearData.findRank(name.getName()));
            } catch (Exception e) {
                rankDiff = Math.abs(name.getRank() - (newYearData.size() + 1));
            }
            if (rankDiff == maxRankDiffValue) {
                maxRankDiffNames.add(name.getName());
            } else if (rankDiff > maxRankDiffValue) {
                maxRankDiffNames.clear();
                maxRankDiffNames.add(name.getName());
                maxRankDiffValue = rankDiff;
            }
        }
        maxRankDiffNames.sort(String::compareTo);
        return maxRankDiffNames;
    }
}
