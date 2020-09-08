package names;

import java.util.ArrayList;
import java.util.List;

public class Basic2 {

    /**
     * Finds the names in the most recent year with the same rank as
     * the name/gender pair from a given year
     * @param name of name/gender pair
     * @param gender of name/gender pair
     * @param year to find rank of name/gender pair
     * @return an alphabetically sorted list containing name/gender pairs
     * ranked at same rank in most recent year
     * @throws Exception
     */

    public static List<String> findNamesOfEqualRank(String name,String gender,int year) throws Exception {
        List<String> ret = new ArrayList<String>();
        int mostRecentYear = Main.findMaxYear();
        NameArray old = new NameArray(gender, year);
        NameArray recentMale = new NameArray("M", mostRecentYear);
        NameArray recentFemale = new NameArray("F", mostRecentYear);

        recentMale.rankGenerator();
        recentFemale.rankGenerator();

        int rank = old.findRank(name);
        if (rank < 1) {
            throw new Exception("Name not found in year given");
        }
        for (Name n : recentMale.getNameArray()) {
            if(n.getRank() == rank) {
                ret.add(n.getName() + ", " + n.getGender());
            }
        }
        for (Name n : recentFemale.getNameArray()) {
            if (n.getRank() == rank) {
                ret.add(n.getName() + ", " + n.getGender());
            }
        }
        ret.sort(String::compareTo);
        return ret;
    }
}