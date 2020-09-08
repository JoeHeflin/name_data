package names;

public class Complete6 {

    /**
     * Finds the average rank of a name/gender pair for a number of most recent years
     * @param name of name/gender pair
     * @param gender of name/gender pair
     * @param i is the number of years receding most recent one
     * @return average rank
     * @throws Exception
     */
    public static float mostRecentAvgRank(String name, String gender, int i) throws Exception {
        Main.setDataPath("testdata/");
        int lastYearInData = Main.findMaxYear();
        int[] yearRange = {lastYearInData-i+1,lastYearInData};
        float ret = Main.findAverageRank(yearRange,gender,name);
        return ret;
    }
}
