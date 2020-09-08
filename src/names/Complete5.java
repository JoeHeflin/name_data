package names;

import java.util.ArrayList;
import java.util.List;

public class Complete5 {

    /**
     * Finds name with max rank average over arnge of years
     * @param years [first year, last year]
     * @param gender to find rank from
     * @return average rank
     * @throws Exception
     */
    public static List<String> maxAvgRank(int[] years, String gender) throws Exception {
        NameArray namesInFirstYear = new NameArray(gender, years[0]);
        float maxAvgRankVal = -1;
        List<String> maxAvgRankList = new ArrayList<>();

        for (Name name:namesInFirstYear.nameArray) {
            float avgRank = Main.findAverageRank(years,gender,name.name);
            if (avgRank == maxAvgRankVal) {
                maxAvgRankList.add(name.name);
            } else if (avgRank < maxAvgRankVal || maxAvgRankVal < 0) {
                maxAvgRankList.clear();
                maxAvgRankList.add(name.name);
                maxAvgRankVal = avgRank;
            }
        }
        maxAvgRankList.sort(String::compareTo);
        return maxAvgRankList;
    }
}
