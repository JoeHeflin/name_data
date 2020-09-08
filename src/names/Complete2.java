package names;

public class Complete2 {

    /**
     * Finds cumulative change in rank for a name/gender pair over range of years
     * @param gender in name/gender pair
     * @param name in name/gender pair
     * @param years [first year, last year]
     * @return difference between rank from the first to last year in range
     * @throws Exception
     */
    public static int rankDiff(String gender, String name, int[] years) throws Exception{
        NameArray oldYearData = new NameArray(gender, years[0]);
        NameArray newYearData = new NameArray(gender, years[1]);

        int oldRank = oldYearData.findRank(name);
        int newRank = newYearData.findRank(name);
        return oldRank-newRank;
    }
}
