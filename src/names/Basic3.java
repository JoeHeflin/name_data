package names;

public class Basic3 {

    /**
     * Finds the names that held the top rank the most number of times
     * for a certain gender over a range of years
     * @param years
     * @param gender
     * @return a frequency object containing the most frequently top ranked names and
     * how often they were ranked number 1
     * @throws Exception
     */
    public static Frequencies findMostTopRanks(int[] years, String gender) throws Exception {
        Frequencies f = new Frequencies();
        f.maxNameFreq(years, gender);
        return f;
    }
}
