package names;

import java.util.ArrayList;
import java.util.List;

public class Complete3 {
    public static List<String> run(int[] years, String gender) throws Exception {
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
