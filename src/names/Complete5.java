package names;

import java.util.ArrayList;
import java.util.List;

public class Complete5 {
    public static List<String> run(int[] years, String gender) throws Exception {
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
