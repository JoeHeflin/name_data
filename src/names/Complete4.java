package names;

public class Complete4 {

    /**
     * Finds a name/gender pair's average rank over a range of years
     * @param name in name/gender pair
     * @param gender in name/gender pair
     * @param years [first year, last year]
     * @return average rank
     * @throws Exception
     */
    public static float avgRank(String name, String gender, int[] years) throws Exception {
        float ret = Main.findAverageRank(years,gender,name);
        return ret;
    }
}
