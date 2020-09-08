package names;

import java.util.ArrayList;
import java.util.List;


/**
 * This method sucks, consider moving to Main, refactoring complete8, maxnamefreq, and maxnameatrank
 */
public class Complete7 {

    /**
     * Finds names that held a certain rank each year over a range of years
     * @param years [first year, last year]
     * @param gender of name/gender pair
     * @param rank in name count for a single year
     * @return names that held the given rank
     * @throws Exception
     */
    public static List<String> namesAtRank(int[] years, String gender, int rank) throws Exception {
        List<String> ret = new ArrayList<>();
        for (int year = years[0]; year<=years[1];year++) {
            List<String> namesPerYearList = new ArrayList<>();
            NameArray n = new NameArray(gender,year);
            n.rankGenerator();
            for (Name name:n.getNameArray()) {
                if (name.getRank() == rank) {
                    namesPerYearList.add(name.getName());
                }
            }
            namesPerYearList.sort(String::compareTo);
            String namesPerYearString = namesPerYearList.get(0);
            if (namesPerYearList.size()>1) {
                for (String name : namesPerYearList.subList(1, namesPerYearList.size())) {
                    namesPerYearString = namesPerYearString + ", " + name;
                }
            }
            ret.add(namesPerYearString);
        }
        return ret;
    }
}
